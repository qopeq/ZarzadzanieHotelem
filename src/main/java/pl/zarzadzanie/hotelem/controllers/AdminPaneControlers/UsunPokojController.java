package pl.zarzadzanie.hotelem.controllers.AdminPaneControlers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pl.zarzadzanie.hotelem.database.EnityModels.Personel;
import pl.zarzadzanie.hotelem.database.EnityModels.Pokoje;
import pl.zarzadzanie.hotelem.database.HibernateUtil;

import java.util.List;

public class UsunPokojController extends UsunPersonelController {

    private List<Pokoje> lista;

    public void boxHandler(){
        lista = HibernateUtil.listujRekordy(new Pokoje());
        ObservableList<String> elements = FXCollections.observableArrayList(
        );
        for(int i = 0; i < lista.size(); i++){
            if(lista.get(i) != null) elements.add(String.valueOf(lista.get(i).getNumer_pokoju()));
        }
        FXCollections.sort(elements);
        wybierzBox.setItems(elements);
    }

    protected int przeszukajListe(String nazwa){

        for(int i = 0; i < lista.size(); i++){
            if(lista.get(i) != null) {

                if(lista.get(i).getNumer_pokoju() == Integer.parseInt(nazwa)) {
                    return i;
                }
            }
        }
        return 0;
    }
}
