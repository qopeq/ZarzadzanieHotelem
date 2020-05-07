package pl.zarzadzanie.hotelem.database.EnityModels;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Klienci.class)
public abstract class Klienci_ {

	public static volatile SingularAttribute<Klienci, Long> PESEL;
	public static volatile SingularAttribute<Klienci, String> telefon;
	public static volatile SingularAttribute<Klienci, Long> k_id;
	public static volatile SingularAttribute<Klienci, String> nazwa;

	public static final String P_ES_EL = "PESEL";
	public static final String TELEFON = "telefon";
	public static final String K_ID = "k_id";
	public static final String NAZWA = "nazwa";

}

