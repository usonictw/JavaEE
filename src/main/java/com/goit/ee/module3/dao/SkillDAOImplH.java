package com.goit.ee.module3.dao;

import com.goit.ee.module3.dto.Skill;
import com.goit.ee.module3.util.HibernateSessionFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SkillDAOImplH implements SkillsDAO {


    @Override
    public void create(Skill skill) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.save(skill);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.getTransaction();
            session.clear();
        }

    }

    @Override
    public Skill get(long id) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        try {
            Object persistenceInstance = session.get(Skill.class, id);
            return (Skill) persistenceInstance;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.getTransaction().commit();
            session.clear();
        }
        return null;
    }

    @Override
    public void update(Skill skill, long id) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.update(skill);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           session.flush();
           session.getTransaction().commit();
           session.clear();
        }
    }

    @Override
    public void delete(long id) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Object persistentInstance = session.load(Skill.class, id);
        if (persistentInstance != null) {
            session.delete(persistentInstance);
            session.flush();
            session.getTransaction().commit();
            session.clear();
        }
    }

    @Override
    public List<Skill> findByName(String nameSkills) {
        return null;
    }

    public Set<Skill> getAll() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            return new HashSet<>(session.createQuery("select s from Skill as s").list());
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            tx.commit();
            session.close();
        }
        return null;
    }

}
