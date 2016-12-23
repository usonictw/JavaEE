package com.goit.ee.module2.dao;

import com.goit.ee.module2.dto.Developer;
import com.goit.ee.module2.util.HibernateSessionFactory;
import org.hibernate.Session;
import java.util.List;

public class DevelopersDAOImplH implements DevelopersDAO {

    private Session session = HibernateSessionFactory.getSessionFactory().getCurrentSession();

    @Override
    public void create(Developer developer) {

        try {
            session.save(developer);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public Developer get(long id) {
        try {
            Object persistentInstance = session.load(Developer.class, id);
            return (Developer) persistentInstance;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public void update(Developer developer) {
        try {
            session.update(developer);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }


    @Override
    public void delete(long id) {
        try {
            session.delete(get(id));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

    }

    @Override
    public boolean findByName(String name) {
        return false;
    }

    @Override
    public boolean findByNameAndLastName(String name, String lastName) {
        return false;
    }

    public List getAll() {

        return session.createQuery("SELECT  d FROM Developer d").list();
    }

    public void setSession(Session session) {
        this.session = session;
    }
}
