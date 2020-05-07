package pl.zarzadzanie.hotelem.database.EnityModels;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "KLIENCI")
public class Klienci implements Serializable {

    @Id
    @GeneratedValue(generator="KLIENCI_KLIENCI_ID_SEQ")
    @Column(name = "K_ID")
    private Long k_id;

    @Column(name = "NAZWA")
    private String nazwa;

    @Column(name = "TELEFON")
    private String telefon;

    @Column(name = "PESEL")
    private Long PESEL;

    public Long getK_id() {
        return k_id;
    }

    public void setK_id(Long k_id) {
        this.k_id = k_id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public Long getPESEL() {
        return PESEL;
    }

    public void setPESEL(Long PESEL) {
        this.PESEL = PESEL;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
}
