package pl.zarzadzanie.hotelem.controllers.PaneCenterControllers;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.input.ContextMenuEvent;
import pl.zarzadzanie.hotelem.database.EnityModels.Klienci;
import pl.zarzadzanie.hotelem.database.EnityModels.Rezerwacje;
import pl.zarzadzanie.hotelem.database.HibernateUtil;

import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class rezerwujController {
    public DatePicker od_termin;
    public DatePicker do_termin;
    public ToggleGroup rodzaj_pokoju;
    public Button mainButton;
    public ChoiceBox dostepmeChoiceBox;
    public TextField peselLabel;
    public TextField telefonLabel;
    public TextField nazwaLabel;
    public static Rezerwacje rezerwacje = null;
    public static Klienci klienci = null;
    public TextField rabat;
    public TextField kara;


    public void dostepmeChoiceBoxRefresh(){
        if(rodzaj_pokoju.getSelectedToggle() != null && od_termin.getValue() != null && do_termin.getValue() != null)
        {
           dostepmeChoiceBox.getItems().setAll(HibernateUtil.listujDostepnePokoje(Date.from(od_termin.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()), Date.from(do_termin.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()), rodzaj_pokoju.getSelectedToggle().toString()));
        }
        else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("Za malo danych!");
            alert.setContentText("Wybierz oba terminy oraz rodzaj pokoju!");

            Optional<ButtonType> result = alert.showAndWait();
            if(result.get() == ButtonType.OK){
                alert.close();
            }
        }
    }


    public void mainAction(ActionEvent actionEvent) {
        rezerwacje = new Rezerwacje();
        rezerwacje.setOplacone(false);
        rezerwacje.setDo_termin(Date.from(od_termin.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));

        try {
            rezerwacje.setKara_kara_id(Long.parseLong(kara.getText()));
        }catch (Exception ex){
            rezerwacje.setKara_kara_id(null);
        }
        rezerwacje.setOd(Date.from(do_termin.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        rezerwacje.setPokoje_numer_pokoju(Long.parseLong(dostepmeChoiceBox.getValue().toString()));

        try {
            rezerwacje.setRabat_rabat_id(Long.parseLong(rabat.getText()));
        }catch (Exception ex){
            rezerwacje.setRabat_rabat_id(null);
        }

        klienci = new Klienci();
        klienci.setNazwa(nazwaLabel.getText());
        klienci.setPESEL(Long.parseLong(peselLabel.getText()));
        klienci.setTelefon(telefonLabel.getText());

        if(HibernateUtil.zapiszElement(klienci)) {
            rezerwacje.setKlienci_klienci_id(klienci.getK_id());

            HibernateUtil.zapiszElement(rezerwacje);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Nowa Rezerwacja");
            alert.setHeaderText("Rezerwacja zakonczona pomyslnie!");
            alert.setContentText("Numer rezerwacji to " + rezerwacje.getRezerwacje_id());

            Optional<ButtonType> result = alert.showAndWait();
            if(result.get() == ButtonType.OK){
                alert.close();
            }
        }

    }
}
