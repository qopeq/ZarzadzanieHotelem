package pl.zarzadzanie.hotelem.controllers.PaneCenterControllers;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

import pl.zarzadzanie.hotelem.database.EnityModels.*;
import pl.zarzadzanie.hotelem.database.HibernateUtil;

import java.math.BigDecimal;
import java.util.Optional;


public class sprawdzRezerwacjeController {

    public TextField szukajLabel;
    public Button szukajButton;
    public Button usunButton;
    public Button karaButton;
    public Button zaplaconeButton;
    public Label odLabel;
    public Label doLabel;
    public Label numerPokojuLabel;
    public Label oplaconeLabel;
    public Label karaLabel;
    public Label rabatLabel;
    public Label kwotaLabel;
    public Label nazwaLabel;
    public Label telefonLabel;
    public Label infoLabel;
    public Tooltip toolTipKara;
    public static Rezerwacje rezerwacje = null;
    public static Klienci klienci = null;
    public static Rabat rabat = null;
    public static Kara kara = null;
    public static Pokoje pokoje = null;


    public void szukajOnAction(){
        if(szukajLabel.getText()!= null ) {

            HibernateUtil.szukajRezerwacje(Long.parseLong(szukajLabel.getText()));

            if(rezerwacje != null && klienci != null){
                odLabel.setText(rezerwacje.getOd().toString().replace("00:00:00.0", ""));
                doLabel.setText(rezerwacje.getDo_termin().toString().replace("00:00:00.0", ""));
                numerPokojuLabel.setText(String.valueOf(rezerwacje.getPokoje_numer_pokoju()));
                oplaconeLabel.setText(Boolean.toString(rezerwacje.isOplacone()));
                nazwaLabel.setText(klienci.getNazwa());
                telefonLabel.setText(klienci.getTelefon());
                BigDecimal kwota = HibernateUtil.getKwota(rezerwacje.getRezerwacje_id());
                if(kwota != null){
                    kwotaLabel.setText(kwota.toString());
                }
                if(kara != null) {
                    toolTipKara.setText(kara.getOpis());
                    karaLabel.setText(kara.getWielkosc_kary().toString());
                }else{
                    karaLabel.setText("0");
                }

                if(rabat != null){
                    rabatLabel.setText(rabat.getWielkosc_rabatu().toString());
                }
                karaButton.setDisable(false);
                usunButton.setDisable(false);
                zaplaconeButton.setDisable(false);

            }
            if(pokoje != null) {
                infoLabel.setWrapText(true);
                infoLabel.setText("Cena : " + pokoje.getCena().toString() + "   Rodzaj : " + pokoje.getRodzaj() + "   Ilosc miejsc : " + pokoje.getIlosc_miejsc() + " \nOpis : " + pokoje.getOpis());
            }
        }
        if(rezerwacje == null){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Sprawdz Rezerwacje");
            alert.setHeaderText("Blad!");
            alert.setContentText("Brak rezerwacji o podanym numerze");

            Optional<ButtonType> result = alert.showAndWait();
            if(result.get() == ButtonType.OK){
                alert.close();
            }
        }

    }

    public void usunOnAction(ActionEvent actionEvent) {
            HibernateUtil.usunElement(rezerwacje);

            karaButton.setDisable(true);
            usunButton.setDisable(true);
            zaplaconeButton.setDisable(true);

    }

    public void karaOnAction(ActionEvent actionEvent) {
        Kara nowaKara = new Kara();

        TextInputDialog textInputDialog = new TextInputDialog();
        textInputDialog.setTitle("Nowa kara");
        textInputDialog.setContentText("Opis Kary");
        Optional<String> result = textInputDialog.showAndWait();
        if (result.get() != null) {
            nowaKara.setOpis(textInputDialog.getEditor().getText());
        }

        TextInputDialog textInputDialog1 = new TextInputDialog();
        textInputDialog1.setTitle("Nowa kara");
        textInputDialog1.setHeaderText("Wielkosc kary");
        textInputDialog1.setContentText("Wielkosc kary");
        Optional<String> result1 = textInputDialog1.showAndWait();
        if (result1.get() != null) {
            nowaKara.setWielkosc_kary(Double.parseDouble(textInputDialog1.getEditor().getText()));
            textInputDialog1.close();
        }

        HibernateUtil.zapiszElement(nowaKara);
        if(rezerwacje != null){
            rezerwacje.setKara_kara_id(nowaKara.getKara_id());
            HibernateUtil.updateElement(rezerwacje);

            kara = nowaKara;
            if(kara != null) {
                toolTipKara.setText(kara.getOpis());
                karaLabel.setText(kara.getWielkosc_kary().toString());
            }else{
                karaLabel.setText("0");
            }
        }

    }

    public void zaplaconeOnAction(ActionEvent actionEvent) {
            rezerwacje.setOplacone(true);
            HibernateUtil.updateElement(rezerwacje);
            oplaconeLabel.setText(Boolean.toString(rezerwacje.isOplacone()));
    }
}
