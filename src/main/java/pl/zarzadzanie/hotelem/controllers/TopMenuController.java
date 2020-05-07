package pl.zarzadzanie.hotelem.controllers;

import pl.zarzadzanie.hotelem.UsefulStuff;

public class TopMenuController {

    private MainController mainController;

    public void startRezerwacji() {
        mainController.setCenter("/fxml/fxmlTopMenu/RezerwujPage.fxml");
    }

    public void startSprawdzRezerwacje() {
        mainController.setCenter("/fxml/fxmlTopMenu/SprawdzRezeracjePage.fxml");
    }

    public void startAdmin() {
        if(UsefulStuff.personel != null) {
            if (UsefulStuff.personel.isAdmin()) {
                mainController.setCenter("/fxml/fxmlTopMenu/fxmlAdmin/AdminPage.fxml");
            }
        }
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
}
