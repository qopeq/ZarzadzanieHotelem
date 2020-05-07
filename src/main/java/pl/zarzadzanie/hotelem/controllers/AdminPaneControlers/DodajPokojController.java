package pl.zarzadzanie.hotelem.controllers.AdminPaneControlers;

import javafx.scene.control.*;
import pl.zarzadzanie.hotelem.database.EnityModels.Pokoje;
import pl.zarzadzanie.hotelem.database.HibernateUtil;

import java.util.Optional;

public class DodajPokojController {
    public TextField numerPokoju;
    public TextField iloscMiejsc;
    public TextField cena;
    public TextField opis;
    public ChoiceBox rodzaj;
    public Button zatwierdz;

    public void action(){
        if(iloscMiejsc.getText() != null && cena.getText() != null && rodzaj.getSelectionModel().getSelectedItem() != null && numerPokoju.getText() != null){
            Pokoje pokoj = new Pokoje();
            pokoj.setCena(Double.parseDouble(cena.getText()));
            pokoj.setIlosc_miejsc(Integer.parseInt(iloscMiejsc.getText()));
            pokoj.setRodzaj(rodzaj.getSelectionModel().getSelectedItem().toString());
            pokoj.setNumer_pokoju(Integer.parseInt(numerPokoju.getText()));
            if(opis.getText() != null) pokoj.setOpis(opis.getText());

            if(HibernateUtil.updateElement(pokoj) == false) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Nowa Pokoj");
                alert.setHeaderText("Blad!");
                alert.setContentText("Numer Pokoju zajety!");

                Optional<ButtonType> result = alert.showAndWait();
                if(result.get() == ButtonType.OK){
                    alert.close();
                }
            }
        }
    }

}
