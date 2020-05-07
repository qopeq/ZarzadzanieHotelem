package pl.zarzadzanie.hotelem.database.EnityModels;

import javax.persistence.*;
import java.io.Serializable;

@Entity@IdClass(Personel.class)
@Table(name = "Personel")
public class Personel implements Serializable {

    @Id@Column(name = "imie")
    private String imie;

    @Id@Column(name = "nazwisko")
    private String nazwisko;

    @Id@Column(name = "telofon")
    private String telofon;

    @Column(name = "login")
    private String login;

    @Column(name = "haslo")
    private String haslo;

    @Column(name = "admin")
    private boolean admin;

    public Personel(){}

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getTelofon() {
        return telofon;
    }

    public void settelofon(String telofon) {
        this.telofon = telofon;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}
