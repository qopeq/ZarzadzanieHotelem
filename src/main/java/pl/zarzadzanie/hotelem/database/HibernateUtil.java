package pl.zarzadzanie.hotelem.database;

import org.hibernate.HibernateException;
import org.hibernate.ObjectDeletedException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;
import pl.zarzadzanie.hotelem.UsefulStuff;
import pl.zarzadzanie.hotelem.controllers.PaneCenterControllers.sprawdzRezerwacjeController;
import pl.zarzadzanie.hotelem.database.EnityModels.*;

import javax.persistence.NoResultException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Date;


public class HibernateUtil{

    public static SessionFactory sessionFactory;

    public static boolean bulidSessionFactiory(){
        try{
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .configure("hibernate.cfg.xml").build();

            Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();

            sessionFactory = metadata.getSessionFactoryBuilder().build();
            return true;
        }catch (Throwable ex){
            System.err.println("Blad w tworzeniu sessionFactory." + ex);
            return false;
            //throw new ExceptionInInitializerError(ex);
        }
    }


    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown(){
        getSessionFactory().close();
    }

    public static boolean checkLoginPassword(String login, String haslo){
        Session session = null;

        try {
            session = getSessionFactory().getCurrentSession();
            session.getTransaction().begin();

             Query<Personel> query = session.createQuery("Select p from " + Personel.class.getName() + " p where p.login = :login and p.haslo = :haslo")
                    .setParameter("login", login)
                    .setParameter("haslo", haslo);
            UsefulStuff.personel = query.getSingleResult();

            session.getTransaction().commit();

            return true;
        }catch (NoResultException ex) {
            System.err.println("NoResultException");
            session.getTransaction().commit();
            return false;
        }
    }

    public static void szukajRezerwacje(Long numerRezerwacji) {
        Session session = null;

        try {
            session = getSessionFactory().getCurrentSession();
            session.getTransaction().begin();

            Query<Kara> query = session.createQuery("Select p from " + Kara.class.getName() + " p where p.kara_id in (select r.kara_kara_id from Rezerwacje r where r.rezerwacje_id = :numerRezerwacji)")
                    .setParameter("numerRezerwacji", numerRezerwacji);
            sprawdzRezerwacjeController.kara = query.getSingleResult();

            session.getTransaction().commit();

        } catch (NoResultException ex) {
            System.err.println("NoResultExceptionKARA");
            session.getTransaction().commit();
        }catch (Exception ex){
            ex.printStackTrace();
            session.getTransaction().commit();
        }

        try {
            session = getSessionFactory().getCurrentSession();
            session.getTransaction().begin();

            Query<Rabat> query1 = session.createQuery("Select p from " + Rabat.class.getName() + " p where p.rabat_id in (select r.rabat_rabat_id from Rezerwacje r where r.rezerwacje_id = :numerRezerwacji)")
                    .setParameter("numerRezerwacji", numerRezerwacji);
            sprawdzRezerwacjeController.rabat = query1.getSingleResult();

            session.getTransaction().commit();

        } catch (NoResultException ex) {
            System.err.println("NoResultExceptionRABAT");
            session.getTransaction().commit();
        }

        try {
            session = getSessionFactory().getCurrentSession();
            session.getTransaction().begin();

            //Query<Klienci> query2 = session.createQuery("Select p from " + Klienci.class.getName() + " p where p.k_id in (select r.klienci_klienci_id from Rezerwacje r where r.rezerwacje_id = :numerRezerwacji)")
            //        .setParameter("numerRezerwacji", numerRezerwacji);
            //sprawdzRezerwacjeController.klienci = query2.getSingleResult();

            //Query<Rezerwacje> query3 = session.createQuery("Select p from " + Rezerwacje.class.getName() + " p where p.rezerwacje_id = :numerRezerwacji")
            //        .setParameter("numerRezerwacji", numerRezerwacji);
            //sprawdzRezerwacjeController.rezerwacje = query3.getSingleResult();

            //Query<Pokoje> query4 = session.createQuery("Select p from " + Pokoje.class.getName() + " p where p.numer_pokoju in (select r.pokoje_numer_pokoju from Rezerwacje r where r.rezerwacje_id = :numerRezerwacji)")
            //        .setParameter("numerRezerwacji", numerRezerwacji);
            //sprawdzRezerwacjeController.pokoje = query4.getSingleResult();


            sprawdzRezerwacjeController.rezerwacje = session.get(Rezerwacje.class, numerRezerwacji);


            session.getTransaction().commit();

        } catch (NoResultException ex) {
            System.err.println("NoResultException");
            session.getTransaction().commit();
        }

        try {

            session = getSessionFactory().getCurrentSession();
            session.getTransaction().begin();
            if(sprawdzRezerwacjeController.rezerwacje != null) {
                if (sprawdzRezerwacjeController.rezerwacje.getKlienci_klienci_id() != null && (sprawdzRezerwacjeController.rezerwacje.getPokoje_numer_pokoju() != null)) {

                    sprawdzRezerwacjeController.klienci = session.get(Klienci.class, sprawdzRezerwacjeController.rezerwacje.getKlienci_klienci_id());

                    sprawdzRezerwacjeController.pokoje = session.get(Pokoje.class, new Integer(sprawdzRezerwacjeController.rezerwacje.getPokoje_numer_pokoju().intValue()));

                }
            }
            session.getTransaction().commit();
        }catch (NoResultException ex) {
            System.err.println("NoResultException");
            session.getTransaction().commit();
        }catch (Exception ex){
            ex.printStackTrace();
            session.getTransaction().commit();
        }
    }

    public static BigDecimal getKwota(Long numerRezerwacji){

        Session session = null;
        BigDecimal xd;

        try {
            session = getSessionFactory().getCurrentSession();
            session.getTransaction().begin();

            Query<BigDecimal> query = session.createNativeQuery("Select ile_do_zaplaty(:numerRezerwacji) from Rezerwacje p where p.rezerwacje_id = :numerRezerwacji")
                    .setParameter("numerRezerwacji", numerRezerwacji);
            xd = query.getSingleResult();

            session.getTransaction().commit();
            return xd;
        }catch (NoResultException ex) {
            System.err.println("NoResultException");
            session.getTransaction().commit();
            return null;
        }

    }

    public static void usunElement(Serializable entity){
        Session session = null;

        try {
            session = getSessionFactory().getCurrentSession();
            session.getTransaction().begin();

            session.delete(entity);

            session.getTransaction().commit();
        }catch (ObjectDeletedException ex) {
            System.err.println("NoObjectDeleteException");
            session.getTransaction().commit();
        }

    }

    public static boolean zapiszElement(Serializable entity){
        Session session = null;

        try {
            session = getSessionFactory().getCurrentSession();
            session.getTransaction().begin();

            session.save(entity);

            session.getTransaction().commit();
            return true;
        }catch (HibernateException ex) {
            System.err.println("HibernateExceptionSave");
            ex.printStackTrace();
            session.getTransaction().commit();
            return false;
        }catch (Exception ex){
            System.err.println("HibernateExceptionSave");
            ex.printStackTrace();
            session.getTransaction().commit();
            return false;
        }
    }

    public static boolean updateElement(Serializable entity){
        Session session = null;

        try {
            session = getSessionFactory().getCurrentSession();
            session.getTransaction().begin();

            session.saveOrUpdate(entity);


            session.getTransaction().commit();
            return true;
        }catch (HibernateException ex) {
            System.err.println("HibernateExceptionSaveOrUpdate");
            session.getTransaction().commit();
            return false;
        }catch (Exception ex){
            System.err.println("HibernateExceptionSaveOrUpdate");
            session.getTransaction().commit();
            return false;
        }
    }

    private static List listujPokojeWgRodzaju(String rodzaj_pokoju){
        Session session = null;
        try {
            session = getSessionFactory().getCurrentSession();
            session.getTransaction().begin();

            Query query = session.createQuery("Select numer_pokoju from " + Pokoje.class.getName() + " p where p.rodzaj = :rodzaj_pokoju")
                    .setParameter("rodzaj_pokoju", rodzaj_pokoju.substring(rodzaj_pokoju.indexOf("'"), rodzaj_pokoju.lastIndexOf("'")).replace("'", ""));

            List<String> list = query.list();

            session.getTransaction().commit();
            return list;
        }catch (NoResultException ex) {
            System.err.println("NoResultException");
            session.getTransaction().commit();
            return null;
        }
    }

    public static List listujDostepnePokoje(Date od_termin, Date do_termin, String rodzaj_pokoju){
        Session session = null;

        try {
            session = getSessionFactory().getCurrentSession();
            session.getTransaction().begin();


            List<Rezerwacje> list = (List<Rezerwacje>) session.createQuery("from Rezerwacje").list();


            session.getTransaction().commit();
            List listaPokoi = listujPokojeWgRodzaju(rodzaj_pokoju);
            for(int i = 0; i < list.size(); i++){
                if(!((list.get(i).getDo_termin().before(od_termin) || list.get(i).getDo_termin().after(do_termin)) && (list.get(i).getOd().before(od_termin) || list.get(i).getOd().after(do_termin)) && !(list.get(i).getOd().before(od_termin) && list.get(i).getDo_termin().after(do_termin)))){
                    listaPokoi.remove((Object)list.get(i).getPokoje_numer_pokoju());
                }
            }
            return listaPokoi;

        }catch (NoResultException ex) {
            System.err.println("NoResultException");
            session.getTransaction().commit();
            return null;
        }
    }

    public static List listujRekordy(Serializable entity){
        Session session = null;
        try {
            session = getSessionFactory().getCurrentSession();
            session.getTransaction().begin();

            Query query = session.createQuery("from " + entity.getClass().getName());

            List list = query.list();

            session.getTransaction().commit();
            return list;
        }catch (NoResultException ex) {
            System.err.println("NoResultException");
            session.getTransaction().commit();
            return null;
        }
    }

}
