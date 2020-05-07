package pl.zarzadzanie.hotelem.database.EnityModels;

import org.hibernate.annotations.GenericGenerators;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "Rezerwacje")
public class Rezerwacje implements Serializable {

    @Column(name = "od")
    private Date od;

    @Column(name = "do_termin")
    private Date do_termin;

    @Column(name = "oplacone")
    private boolean oplacone;

    @Column(name = "pokoje_numer_pokoju")
    private Long pokoje_numer_pokoju;

    @Id
    @GeneratedValue(generator="REZERWACJE_REZERWACJE_ID_SEQ")
    @Column(name = "rezerwacje_id")
    private Long rezerwacje_id;

    @Column(name = "klienci_klienci_id")
    private Long klienci_klienci_id;

    @Column(name = "kara_kara_id")
    private Long kara_kara_id;

    @Column(name = "rabat_rabat_id")
    private Long rabat_rabat_id;


    public Date getOd() {
        return od;
    }

    public void setOd(Date od) {
        this.od = od;
    }

    public Date getDo_termin() {
        return do_termin;
    }

    public void setDo_termin(Date do_termin) {
        this.do_termin = do_termin;
    }

    public boolean isOplacone() {
        return oplacone;
    }

    public void setOplacone(boolean oplacone) {
        this.oplacone = oplacone;
    }

    public Long getPokoje_numer_pokoju() {
        return pokoje_numer_pokoju;
    }

    public void setPokoje_numer_pokoju(Long pokoje_numer_pokoju) {
        this.pokoje_numer_pokoju = pokoje_numer_pokoju;
    }

    public Long getKlienci_klienci_id() {
        return klienci_klienci_id;
    }

    public void setKlienci_klienci_id(Long klienci_klienci_id) {
        this.klienci_klienci_id = klienci_klienci_id;
    }

    public Long getKara_kara_id() {
        return kara_kara_id;
    }

    public void setKara_kara_id(Long kara_kara_id) {
        this.kara_kara_id = kara_kara_id;
    }

    public Long getRabat_rabat_id() {
        return rabat_rabat_id;
    }

    public void setRabat_rabat_id(Long rabat_rabat_id) {
        this.rabat_rabat_id = rabat_rabat_id;
    }

    public Long getRezerwacje_id() {
        return rezerwacje_id;
    }

    public void setRezerwacje_id(Long rezerwacje_id) {
        this.rezerwacje_id = rezerwacje_id;
    }
}
