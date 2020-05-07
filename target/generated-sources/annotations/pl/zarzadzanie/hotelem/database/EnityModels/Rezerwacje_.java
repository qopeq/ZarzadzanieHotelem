package pl.zarzadzanie.hotelem.database.EnityModels;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Rezerwacje.class)
public abstract class Rezerwacje_ {

	public static volatile SingularAttribute<Rezerwacje, Date> do_termin;
	public static volatile SingularAttribute<Rezerwacje, Boolean> oplacone;
	public static volatile SingularAttribute<Rezerwacje, Long> rabat_rabat_id;
	public static volatile SingularAttribute<Rezerwacje, Date> od;
	public static volatile SingularAttribute<Rezerwacje, Long> kara_kara_id;
	public static volatile SingularAttribute<Rezerwacje, Long> rezerwacje_id;
	public static volatile SingularAttribute<Rezerwacje, Long> pokoje_numer_pokoju;
	public static volatile SingularAttribute<Rezerwacje, Long> klienci_klienci_id;

	public static final String DO_TERMIN = "do_termin";
	public static final String OPLACONE = "oplacone";
	public static final String RABAT_RABAT_ID = "rabat_rabat_id";
	public static final String OD = "od";
	public static final String KARA_KARA_ID = "kara_kara_id";
	public static final String REZERWACJE_ID = "rezerwacje_id";
	public static final String POKOJE_NUMER_POKOJU = "pokoje_numer_pokoju";
	public static final String KLIENCI_KLIENCI_ID = "klienci_klienci_id";

}

