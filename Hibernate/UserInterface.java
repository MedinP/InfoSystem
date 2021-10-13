import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class UserInterface {
    static Connection connection;


    public static void enterWorkers(Session ses, Transaction ts, Workers workers) {
        ses.save(workers);
        ts.commit();
        ses.close();
    }

    public static void updateWorkers(Session ses, Transaction ts, int id, Workers ww) {
        Workers w = (Workers) ses.get(Workers.class, id);
        w.setAdress(ww.getAdress());
        w.setAge(ww.getAge());
        w.setSellery(ww.getSellery());

        ses.update(w);
        ts.commit();
        ses.close();
    }

    public static void deleteWorkers(Session session, Transaction transaction, int id) {
        Workers w = (Workers) session.get(Workers.class, id);
        session.delete(w);
        transaction.commit();
        session.close();
    }

    public static ArrayList<Workers> showAll(Session session, Transaction transaction) {
        ArrayList<Workers> workers = (ArrayList<Workers>) session.createQuery("from Workers").list();
        return workers;
    }

    public static Workers showbyID (Session session, Transaction transaction,int id){
        session.get(Workers.class,id);
        Workers w = (Workers) session.get(Workers.class, id);
        transaction.commit();
        session.close();
        return w;
    }
}