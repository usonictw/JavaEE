package com.goit.ee.module3.dao;

import com.goit.ee.module3.dto.Developer;
import com.goit.ee.module3.dto.Skill;
import com.goit.ee.module3.util.HibernateSessionFactory;
import org.hibernate.*;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.goit.ee.module3.contoller.ConsoleUtils.getParam;

public class DevelopersDAOImplH implements DevelopersDAO {

    @Override
    public void create(Developer developer) {
        SkillDAOImplH skillDAOImplH = new SkillDAOImplH();
        Set<Skill> skills = new HashSet<>();
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            System.out.println(skillDAOImplH.getAll());
            long numbersSkills = getParam("Number of skills");
            for (int i = 0; i < numbersSkills; i++) {
                skills.add(session.get(Skill.class, getParam("id of skill")));
            }
            developer.setSkills(skills);
            session.save(developer);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.getTransaction().commit();
            session.clear();
        }
    }

    @Override
    public Developer get(long id) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            return (Developer) session.get(Developer.class, id);
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
    public void update(Developer developer, long id) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            Developer proxyDeveloper = (Developer) session.get(Developer.class, id);
            proxyDeveloper.setFirstName(developer.getFirstName());
            proxyDeveloper.setLastName(developer.getLastName());
            proxyDeveloper.setSalary(developer.getSalary());
            proxyDeveloper.setAge(developer.getAge());
            proxyDeveloper.setSkills(developer.getSkills());
            session.update(proxyDeveloper);
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
        try {
            session.createSQLQuery("DELETE from dev_skills where id_dev = " + id).executeUpdate();
            session.createSQLQuery("DELETE FROM proj_dev WHERE id_dev = " + id).executeUpdate();
            Developer developer = (Developer) session.load(Developer.class, id);
            session.delete(developer);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.getTransaction().commit();
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

    public Set<Developer> getAll() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Set<Developer> developerList;
        try {
            return new HashSet<>(session.createQuery("SELECT  d FROM Developer d").list());
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            tx.commit();
            session.close();
        }
        return Collections.emptySet();
    }
}
