package com.goit.ee.module2.dao;

import com.goit.ee.module2.dto.Skill;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.List;

public class SkillDAOImplH implements SkillsDAO {

    private Session session;

    @Override
    public void create(Skill skill) {

    }

    @Override
    public Skill get(long id) {
        return null;
    }

    @Override
    public void update(Skill skill) {

    }

    @Override
    public void delete(long id) {
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

        return session.createQuery("SELECT s FROM Skill as s").list();
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }
}
