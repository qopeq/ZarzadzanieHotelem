package pl.zarzadzanie.hotelem.database.EnityModels;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "KARA")
public class Kara implements Serializable {
    @Id
    @GeneratedValue(generator="KARA_KARA_ID_SEQ")
    @Column(name = "kara_id")
    private Long kara_id;

    @Column(name = "wielkosc_kary")
    private Double wielkosc_kary;

    @Column(name = "opis")
    private String opis;


    public Long getKara_id() {
        return kara_id;
    }

    public void setKara_id(Long kara_id) {
        this.kara_id = kara_id;
    }

    public void setWielkosc_kary(Double wielkosc_kary) {
        this.wielkosc_kary = wielkosc_kary;
    }

    public Double getWielkosc_kary() {
        return wielkosc_kary;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String toString(){
        return "Kara : " + wielkosc_kary + " PLN ||| Opis : " + opis;
    }
}
