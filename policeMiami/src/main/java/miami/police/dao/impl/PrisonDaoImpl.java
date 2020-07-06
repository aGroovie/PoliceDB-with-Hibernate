package miami.police.dao.impl;

import miami.police.bl.HibernateUtils;
import miami.police.dao.PrisonDao;
import miami.police.model.Person;
import miami.police.model.Prison;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class PrisonDaoImpl implements PrisonDao {


    @Override
    public void savePrison(Prison prison) {
        SessionFactory factory = HibernateUtils.getSessionFactory();
        Session session = factory.getCurrentSession();
        session.getTransaction().begin();
        session.saveOrUpdate(prison);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Prison> findAll() {
        SessionFactory factory = HibernateUtils.getSessionFactory();
        Session session = factory.getCurrentSession();
        session.getTransaction().begin();
        Query query = session.createNativeQuery("SELECT * FROM prison").addEntity(Prison.class);
        List<Prison> prisonList = query.list();
        session.close();
        return prisonList;
    }

    @Override
    public void deletePrisonById(long id) {
        SessionFactory factory = HibernateUtils.getSessionFactory();
        Session session = factory.getCurrentSession();
        session.getTransaction().begin();
        Query query = session.createNativeQuery("DELETE  FROM prison where prison_id = :id").setParameter("id",id);
        query.executeUpdate();
        session.close();
    }
}