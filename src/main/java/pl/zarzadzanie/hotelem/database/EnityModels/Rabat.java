package pl.zarzadzanie.hotelem.database.EnityModels;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "Rabat")
public class Rabat implements Serializable {
    @Id
    @Column(name = "rabat_id")
    private Long rabat_id;

    @Column(name = "kod")
    private Long kod;

    @Column(name = "wielkosc_rabatu")
    private Double wielkosc_rabatu;

    public Long getKod() {
        return kod;
    }

    public void setKod(Long kod) {
        this.kod = kod;
    }

    public Double getWielkosc_rabatu() {
        return wielkosc_rabatu;
    }

    public void setWielkosc_rabatu(Double wielkosc_rabatu) {
        this.wielkosc_rabatu = wielkosc_rabatu;
    }
}
