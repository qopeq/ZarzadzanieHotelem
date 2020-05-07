package pl.zarzadzanie.hotelem.database.EnityModels;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Pokoje")
public class Pokoje implements Serializable {

    @Id
    @Column(name = "numer_pokoju")
    private int numer_pokoju;

    @Column(name = "rodzaj")
    private String rodzaj;

    @Column(name = "ilosc_miejsc")
    private int ilosc_miejsc;

    @Column(name = "opis")
    private String opis;

    @Column(name = "cena")
    private Double cena;

    public int getNumer_pokoju() {
        return numer_pokoju;
    }

    public void setNumer_pokoju(int numer_pokoju) {
        this.numer_pokoju = numer_pokoju;
    }

    public String getRodzaj() {
        return rodzaj;
    }

    public void setRodzaj(String rodzaj) {
        this.rodzaj = rodzaj;
    }

    public int getIlosc_miejsc() {
        return ilosc_miejsc;
    }

    public void setIlosc_miejsc(int ilosc_miejsc) {
        this.ilosc_miejsc = ilosc_miejsc;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Double getCena() {
        return cena;
    }

    public void setCena(Double cena) {
        this.cena = cena;
    }

    public String toString(){
        return "Numer : " + numer_pokoju + "  Rodzaj : " + rodzaj + "  Ilosc miejsc : " + ilosc_miejsc + "  Cena : " + cena + " Opis : " + opis;
    }
}
