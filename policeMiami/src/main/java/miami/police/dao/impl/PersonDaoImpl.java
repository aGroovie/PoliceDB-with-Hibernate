package miami.police.dao.impl;

import miami.police.bl.HibernateUtils;
import miami.police.dao.PersonDao;
import miami.police.model.Person;
import miami.police.model.Prison;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonDaoImpl implements PersonDao {



    @Override
    public void savePerson(Person person) {
        SessionFactory factory = HibernateUtils.getSessionFactory();
        Session session = factory.getCurrentSession();
        session.getTransaction().begin();
        session.saveOrUpdate(person);
        new Prison().getPersons().add(person);
        session.getTransaction().commit();

        session.close();

    }

    @Override
    public List<Person> findAll() {
        SessionFactory factory = HibernateUtils.getSessionFactory();
        Session session = factory.getCurrentSession();
        session.getTransaction().begin();
        Query query = session.createNativeQuery("SELECT * FROM prisoners").addEntity(Person.class);
        List<Person> personList = query.list();
        session.close();
        return personList;
    }

    @Override
    public void deletePersonById(long id) {
        SessionFactory factory = HibernateUtils.getSessionFactory();
        Session session = factory.getCurrentSession();
        session.getTransaction().begin();
        Query query = session.createNativeQuery("DELETE  FROM prisoners where ID = :id").setParameter("id", id);
        query.executeUpdate();
        session.close();
    }
}