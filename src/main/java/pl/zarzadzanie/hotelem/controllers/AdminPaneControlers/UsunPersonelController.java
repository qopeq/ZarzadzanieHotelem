package pl.zarzadzanie.hotelem.controllers.AdminPaneControlers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import pl.zarzadzanie.hotelem.database.EnityModels.Personel;
import pl.zarzadzanie.hotelem.database.HibernateUtil;
import java.util.List;


import java.util.List;

public class UsunPersonelController {

    public ChoiceBox wybierzBox;
    private List<Personel> lista;


    public void boxHandler(){
        lista = HibernateUtil.listujRekordy(new Personel());
        ObservableList<String> elements = FXCollections.observableArrayList(
        );
        for(int i = 0; i < lista.size(); i++){
            if(lista.get(i) != null) elements.add(lista.get(i).getImie() + " " + lista.get(i).getNazwisko());
        }

        wybierzBox.setItems(elements);
    }

    protected int przeszukajListe(String nazwa){
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

    public void usunHandler(){
        if(wybierzBox.getSelectionModel().getSelectedItem() != null){
            int index = przeszukajListe(wybierzBox.getSelectionModel().getSelectedItem().toString());
            if (lista != null)HibernateUtil.usunElement(lista.get(index));
        }
    }
}
