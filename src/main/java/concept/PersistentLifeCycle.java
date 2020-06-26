package concept;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class PersistentLifeCycle {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure().addAnnotatedClass(Laptop.class);
        SessionFactory sf = configuration.buildSessionFactory();
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();

        Laptop laptop = new Laptop();
        laptop.setId(101);
        laptop.setName("Lenovo");
        laptop.setPrice(2000L);

        // before save its in transient state
        session.save(laptop);
        // after save called, its in persistent state and only till transaction is not committed
        // hence price will be updated even after save
        laptop.setPrice(1500L);

        // remove brings the laptop entity to remove state
        // session.remove(laptop);
        transaction.commit();
        // detach method detaches the object Laptop from Persistence,
        // so now setPrice will not be reflected into DB
        session.detach(laptop);
        laptop.setPrice(2500L);

        session.close();

    }
}
