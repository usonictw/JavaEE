package com.goit.ee.module2.dao;

import com.goit.ee.module2.dto.Skill;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by user on 16.12.2016.
 */
public class SkillDAOImplH implements SkillsDAO {

private Session session;

    @Override
    public boolean create(Skill skill) {
        return false;
    }

    @Override
    public boolean get(long id) {
        return false;
    }

    @Override
    public boolean update(Skill skill) {
        return false;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }

    @Override
    public List<Skill> findByName(String nameSkills) {
        return null;
    }

    public List getAll(){

        return session.createSQLQuery("SELECT * FROM skills").list();
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }
}
