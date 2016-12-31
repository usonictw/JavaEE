package com.goit.ee.module3.dao;

import com.goit.ee.module3.dto.Skill;
import com.goit.ee.module3.util.HibernateSessionFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

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
            tx.commit();
            session.close();
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
            session.getTransaction().commit();
            session.close();
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
            tx.commit();
            session.close();
        }
    }

    @Override
    public void delete(long id) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Object persistentInstance = session.load(Skill.class, id);
        if (persistentInstance != null) {
            session.delete(persistentInstance);
            tx.commit();
            session.close();
        }
    }

    @Override
    public List<Skill> findByName(String nameSkills) {
        return null;
    }

    public List getAll() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        List<Skill> skillList = new ArrayList<>();
        Transaction tx = session.beginTransaction();
        try {
            skillList = session.createQuery("select s from Skill as s").list();
            return skillList;
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            tx.commit();
            session.close();
        }
        return null;
    }

}
