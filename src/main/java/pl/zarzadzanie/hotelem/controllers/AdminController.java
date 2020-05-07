package pl.zarzadzanie.hotelem.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SplitPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class AdminController {
    public ToggleGroup admin_grbutton;

    public RadioButton dodajPersonel;
    public RadioButton edytujPersonel;
    public RadioButton usunPersonel;
    public RadioButton dodajPokoj;
    public RadioButton edytujPokoj;
    public RadioButton usunPokoj;

    public SplitPane mainPane;
    private FXMLLoader loader;

    public void listener(){

        if(dodajPersonel.isSelected()){
            loader = new FXMLLoader(this.getClass().getResource("/fxml/fxmlTopMenu/fxmlAdmin/DodajPersonelPage.fxml"));
        }

        if(edytujPersonel.isSelected()){
            loader = new FXMLLoader(this.getClass().getResource("/fxml/fxmlTopMenu/fxmlAdmin/EdytujPersonelPage.fxml"));
        }

        if(usunPersonel.isSelected()){
            loader = new FXMLLoader(this.getClass().getResource("/fxml/fxmlTopMenu/fxmlAdmin/UsunPersonelPage.fxml"));
        }

        if(dodajPokoj.isSelected()){
            loader = new FXMLLoader(this.getClass().getResource("/fxml/fxmlTopMenu/fxmlAdmin/DodajPokojPage.fxml"));
        }

        if(edytujPokoj.isSelected()){
            loader = new FXMLLoader(this.getClass().getResource("/fxml/fxmlTopMenu/fxmlAdmin/EdytujPokojPage.fxml"));
        }

        if(usunPokoj.isSelected()){
            loader = new FXMLLoader(this.getClass().getResource("/fxml/fxmlTopMenu/fxmlAdmin/UsunPokojPage.fxml"));
        }

        Parent parent = null;
        try {
            parent = loader.load();
        } catch (Exception e) {
            e.printStackTrace();
        }

        mainPane.getItems().set(1, parent);

    }

}
