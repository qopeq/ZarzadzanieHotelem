package pl.zarzadzanie.hotelem.controllers;


import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import pl.zarzadzanie.hotelem.UsefulStuff;
import pl.zarzadzanie.hotelem.database.HibernateUtil;

public class LogInController extends UsefulStuff {

    public Button logInButton;
    public Stage logIn;
    public VBox vBox_logIn;
    public static Stage primaryStage;
    public Button cancel;
    public Label label;
    public TextField loginField;
    public TextField passwordField;

    public void cancel(ActionEvent actionEvent) {
        logIn = (Stage) vBox_logIn.getScene().getWindow();
        logIn.close();
        hibernateUtil.shutdown();
        primaryStage.close();
    }

    public void zaloguj(ActionEvent actionEvent) {
        if(HibernateUtil.checkLoginPassword(loginField.getText(), passwordField.getText())){
            logIn = (Stage) vBox_logIn.getScene().getWindow();
            logIn.close();
        }else {
            label.setText("Bledne haslo lub login!");
        }
    }
}
