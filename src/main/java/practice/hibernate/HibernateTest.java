package practice.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import practice.hibernate.model.Name;
import practice.hibernate.model.User;

public class HibernateTest {

    private static SessionFactory sessionFactory = null;

    public static User setUser(String login, String pass) {
        User user = new User();
        user.setLogin(login);
        user.setPass(pass);
        try {
            sessionFactory = new HibernateUtil().getSessionFactory();
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            //Set User
            System.out.println("User ID=" + session.save(user));
            //Commit transaction
            session.getTransaction().commit();
        }
        catch (Exception e ){ e.printStackTrace(); }
        finally {
            sessionFactory.close();
        }
        return user;
    }







    public static Name setName(String name) {
        Name naame = new Name();
        naame.setName(name);
        try {
            sessionFactory = new HibernateUtil().getSessionFactory();
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            System.out.println("Name ID=" + session.save(naame));
            session.getTransaction().commit();
        }
        catch (Exception e ){ e.printStackTrace(); }
        finally {
            sessionFactory.close();
        }
        return naame;
    }




    public static Name getName(Integer id) {
        Name name = null;
        try {
            sessionFactory = new HibernateUtil().getSessionFactory();
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            //Get Name
            name = session.get(Name.class, id);
            System.out.println("name = " + name.getID());

            session.getTransaction().commit();

        }
        catch (Exception e ){ e.printStackTrace(); }
        finally {
            sessionFactory.close();
        }
        return name;
    }

    public static User getUser(Integer id) {
        User user = null;
        try {
            sessionFactory = new HibernateUtil().getSessionFactory();
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            //Get User
            user = session.get(User.class, id);
            System.out.println("user = " + user.getId());


            //Commit transaction
            session.getTransaction().commit();
            //terminate session factory, otherwise program won't end

        }
        catch (Exception e ){ e.printStackTrace(); }
        finally {
            sessionFactory.close();
        }
        return user;
    }

    public static void main(String[] args) {
//    User user = setUser("teamfindtop@gmail.com","teamfindtop");
//        Name name = setName(("Im bot"));
        Name name = getName(1);
        User user = getUser(4);
        System.out.println(user.getLogin());

    }

}
