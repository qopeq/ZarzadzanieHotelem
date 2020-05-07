package pl.zarzadzanie.hotelem.database.EnityModels;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Pokoje.class)
public abstract class Pokoje_ {

	public static volatile SingularAttribute<Pokoje, Integer> numer_pokoju;
	public static volatile SingularAttribute<Pokoje, Double> cena;
	public static volatile SingularAttribute<Pokoje, Integer> ilosc_miejsc;
	public static volatile SingularAttribute<Pokoje, String> rodzaj;
	public static volatile SingularAttribute<Pokoje, String> opis;

	public static final String NUMER_POKOJU = "numer_pokoju";
	public static final String CENA = "cena";
	public static final String ILOSC_MIEJSC = "ilosc_miejsc";
	public static final String RODZAJ = "rodzaj";
	public static final String OPIS = "opis";

}

