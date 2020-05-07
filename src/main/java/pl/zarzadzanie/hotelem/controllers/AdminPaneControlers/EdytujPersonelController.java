package pl.zarzadzanie.hotelem.controllers.AdminPaneControlers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ChoiceBox;
import pl.zarzadzanie.hotelem.database.EnityModels.Personel;
import pl.zarzadzanie.hotelem.database.HibernateUtil;
import java.util.List;

public class EdytujPersonelController extends DodajPersonelController {
    public ChoiceBox wybierzButton;
    private List<Personel> lista;

    private int przeszukajListe(String nazwa){
        String imie = nazwa.substring(0, nazwa.lastIndexOf(' '));
        String nazwisko = nazwa.substring(nazwa.lastIndexOf(' ') + 1, nazwa.length());

        for(int i = 0; i < lista.size(); i++){
            if(lista.get(i) != null) {

                if(lista.get(i).getNazwisko().equals(nazwisko) && lista.get(i).getImie().equals(imie)) {
                    return i;
                }
            }
        }
        return 0;
    }

    public void wybierzButtonOnAct() {
        lista = HibernateUtil.listujRekordy(new Personel());
        ObservableList<String> elements = FXCollections.observableArrayList(
        );
        for(int i = 0; i < lista.size(); i++){
            if(lista.get(i) != null) elements.add(lista.get(i).getImie() + " " + lista.get(i).getNazwisko());
        }

        wybierzButton.setItems(elements);

        wybierzButton.getSelectionModel().selectedItemProperty().addListener(e -> {
            if(wybierzButton.getSelectionModel() != null && wybierzButton.getSelectionModel().getSelectedItem() != null) {

                int index = przeszukajListe(wybierzButton.getSelectionModel().getSelectedItem().toString());

                if(lista.get(index) != null) {
                    imieText.clear();
                    imieText.insertText(0, lista.get(index).getImie());

                    nazwiskoText.clear();
                    nazwiskoText.insertText(0, lista.get(index).getNazwisko());

                    telefonText.clear();
                    telefonText.insertText(0, lista.get(index).getTelofon());

                    loginText.clear();
                    loginText.insertText(0, lista.get(index).getLogin());

                    hasloText.clear();
                    hasloText.insertText(0, lista.get(index).getHaslo());

                    adminCheckBox.setSelected(lista.get(index).isAdmin());
                }
            }
        });
    }

}
