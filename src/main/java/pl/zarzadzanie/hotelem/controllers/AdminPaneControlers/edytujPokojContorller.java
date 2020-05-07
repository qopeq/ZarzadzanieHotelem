package pl.zarzadzanie.hotelem.controllers.AdminPaneControlers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.SingleSelectionModel;
import pl.zarzadzanie.hotelem.database.EnityModels.Pokoje;
import pl.zarzadzanie.hotelem.database.HibernateUtil;

import java.util.List;

public class edytujPokojContorller extends DodajPokojController {
    public ChoiceBox wyborPokoju;
    private List<Pokoje> lista;

    private Pokoje znajdzPokoj(int x){
        for(int i = 0; i < lista.size(); i++){
            if(lista.get(i).getNumer_pokoju() == x) return lista.get(i);
        }
        return null;
    }

    private boolean sprawdzRodzajLista(ObservableList<String > rodzaje, String szukane){
        for(int i = 0; i < rodzaje.size(); i++){
            if(rodzaje.get(i).equals(szukane)) return false;
        }
        return true;
    }

    public void dodajRekordy(){


        lista = HibernateUtil.listujRekordy(new Pokoje());

        ObservableList<Integer> elements = FXCollections.observableArrayList(
        );
        ObservableList<String > rodzaje = FXCollections.observableArrayList(
        );
        for(int i = 0; i < lista.size(); i++){
            if(lista.get(i) != null) {
                elements.add(lista.get(i).getNumer_pokoju());
                if(sprawdzRodzajLista(rodzaje, lista.get(i).getRodzaj())) rodzaje.add(lista.get(i).getRodzaj());
            }
        }

        FXCollections.sort(elements);

        wyborPokoju.setItems(elements);
        rodzaj.setItems(rodzaje);
        wyborPokoju.getSelectionModel().selectedItemProperty().addListener(e -> {
            if(wyborPokoju.getSelectionModel().getSelectedItem() != null){
                Pokoje edytowanyPokoj;
                if((edytowanyPokoj = znajdzPokoj(Integer.parseInt(wyborPokoju.getSelectionModel().getSelectedItem().toString()))) != null){

                    numerPokoju.setText(String.valueOf(edytowanyPokoj.getNumer_pokoju()));
                    iloscMiejsc.setText(String.valueOf(edytowanyPokoj.getIlosc_miejsc()));
                    cena.setText(String.valueOf(edytowanyPokoj.getCena()));
                    opis.setText(edytowanyPokoj.getOpis());

                    for(int i = 0; i < rodzaje.size(); i++){
                        if(sprawdzRodzajLista(rodzaje, edytowanyPokoj.getRodzaj())){
                            rodzaj.getSelectionModel().select(i);
                        }
                    }
                }
            }
        });
    }
}

