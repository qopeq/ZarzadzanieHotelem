package pl.zarzadzanie.hotelem.controllers.AdminPaneControlers;

import javafx.scene.control.TextField;
import pl.zarzadzanie.hotelem.database.EnityModels.Personel;
import pl.zarzadzanie.hotelem.database.HibernateUtil;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;


public class DodajPersonelController {
    public Button zatwierdzButton;
    public TextField imieText;
    public TextField nazwiskoText;
    public TextField telefonText;
    public TextField loginText;
    public TextField hasloText;
    public CheckBox adminCheckBox;
    private Personel personel = new Personel();

    public void zatwierdzButtonOnAction(){


        personel.setAdmin(adminCheckBox.isSelected());
        personel.setHaslo(hasloText.getText());
        personel.setLogin(loginText.getText());
        personel.settelofon(telefonText.getText());
        personel.setNazwisko(nazwiskoText.getText());
        personel.setImie(imieText.getText());

        HibernateUtil.updateElement(personel);
    }


}
