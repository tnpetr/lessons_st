package ru.st.less.addressbook.appmanager;

import com.mysql.cj.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ru.st.less.addressbook.model.ContactData;
import ru.st.less.addressbook.model.Contacts;
import ru.st.less.addressbook.model.GroupData;
import ru.st.less.addressbook.model.Groups;

import java.util.List;

public class DbHelper {

    private final SessionFactory sessionFactory;

    public DbHelper() {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }

    public Groups groups() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<GroupData> result = session.createQuery("from GroupData").list();
        session.getTransaction().commit();
        session.close();
        return new Groups(result);
    }

    public Contacts contacts() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<ContactData> result = session.createQuery("from ContactData").list();
        session.getTransaction().commit();
        session.close();
        return new Contacts(result);
    }

    public GroupData findGroup(int groupId) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        String query = "from GroupData where id = " + groupId;
        GroupData result = (GroupData) session.createQuery(query).getSingleResult();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    public ContactData findContact(int contactId) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        String query = "from ContactData where id = " + contactId;
        ContactData result = (ContactData) session.createQuery(query).getSingleResult();
        session.getTransaction().commit();
        session.close();
        return result;
    }
}
