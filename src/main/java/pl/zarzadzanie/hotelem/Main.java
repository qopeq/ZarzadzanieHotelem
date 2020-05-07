package pl.zarzadzanie.hotelem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import pl.zarzadzanie.hotelem.controllers.LogInController;
import pl.zarzadzanie.hotelem.database.HibernateUtil;

import java.util.Optional;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        BorderPane borderPane = null;
        Scene scene = null;
        VBox vBox = null;

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/BorderPainMain.fxml"));
        FXMLLoader logLoader = new FXMLLoader(this.getClass().getResource("/fxml/LogInStage.fxml"));

        borderPane = loader.load();
        if(borderPane != null){
            scene = new Scene(borderPane);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Zarzadzanie Hotelem");
            primaryStage.show();

            LogInController.primaryStage = primaryStage;

        }

        vBox = logLoader.load();
        if(vBox != null && scene != null) {
            Scene logScene = new Scene(vBox);
            Stage logIn = new Stage();
            logIn.setScene(logScene);
            logIn.setTitle("Zaloguj");
            logIn.initModality(Modality.APPLICATION_MODAL);
            logIn.setResizable(false);
            logIn.setOnCloseRequest(e -> e.consume());
            logIn.show();

            if(!HibernateUtil.bulidSessionFactiory()){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText("Problem z baza danych");
                alert.setContentText("Problem z nawiazaniem polaczenia!");

                Optional<ButtonType> result = alert.showAndWait();
                if(result.get() == ButtonType.OK){
                    logIn.close();
                    primaryStage.close();
                    alert.close();
                }
            }
            primaryStage.setOnCloseRequest(e -> {
                e.consume();
                UsefulStuff.hibernateUtil.shutdown();
                primaryStage.close();
            });
        }




    }
}
