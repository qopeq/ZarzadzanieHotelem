package pl.zarzadzanie.hotelem.database.EnityModels;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Personel.class)
public abstract class Personel_ {

	public static volatile SingularAttribute<Personel, String> imie;
	public static volatile SingularAttribute<Personel, String> telofon;
	public static volatile SingularAttribute<Personel, String> nazwisko;
	public static volatile SingularAttribute<Personel, Boolean> admin;
	public static volatile SingularAttribute<Personel, String> haslo;
	public static volatile SingularAttribute<Personel, String> login;

	public static final String IMIE = "imie";
	public static final String TELOFON = "telofon";
	public static final String NAZWISKO = "nazwisko";
	public static final String ADMIN = "admin";
	public static final String HASLO = "haslo";
	public static final String LOGIN = "login";

}

