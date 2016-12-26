package com.goit.ee.module2.dao;

import com.goit.ee.module2.dto.Developer;
import com.goit.ee.module2.util.HibernateSessionFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class DevelopersDAOImplH implements DevelopersDAO {

    Session session = HibernateSessionFactory.getSessionFactory().openSession();

    @Override
    public void create(Developer developer) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.save(developer);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            tx.commit();
            session.close();
        }
    }

    @Override
    public Developer get(long id) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            Object persistentInstance = session.load(Developer.class, id);
            return (Developer) persistentInstance;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            tx.commit();
            session.close();
        }
        return null;
    }

    @Override
    public void update(Developer developer) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.update(developer);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            tx.commit();
            session.close();
        }
    }

    @Override
    public void delete(long id) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.delete(get(id));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            tx.commit();
            session.close();
        }
    }

    @Override
    public List<Developer> findByName(String name) {

        return null;
    }

    @Override
    public List<Developer> findByNameAndLastName(String name, String lastName) {
        return null;
    }

    public List<Developer> getAll() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        List<Developer> developerList = new ArrayList<>();
        try {
            developerList = session.createQuery("SELECT  d FROM Developer d").list();
            return developerList;
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            tx.commit();
            session.close();
        }
       return null;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Session getSession() {
        return session;
    }
}
