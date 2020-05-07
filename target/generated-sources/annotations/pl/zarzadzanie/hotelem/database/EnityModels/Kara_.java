package pl.zarzadzanie.hotelem.database.EnityModels;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Kara.class)
public abstract class Kara_ {

	public static volatile SingularAttribute<Kara, Long> kara_id;
	public static volatile SingularAttribute<Kara, Double> wielkosc_kary;
	public static volatile SingularAttribute<Kara, String> opis;

	public static final String KARA_ID = "kara_id";
	public static final String WIELKOSC_KARY = "wielkosc_kary";
	public static final String OPIS = "opis";

}

