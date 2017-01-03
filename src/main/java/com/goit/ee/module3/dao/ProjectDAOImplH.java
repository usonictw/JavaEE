package com.goit.ee.module3.dao;

import com.goit.ee.module3.dto.Project;
import com.goit.ee.module3.util.HibernateSessionFactory;
import org.hibernate.Cache;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class ProjectDAOImplH implements ProjectsDAO {

    @Override
    public void create(Project project) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.save(project);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.getTransaction().commit();
            session.clear();
        }
    }

    @Override
    public Project get(long id) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            Project project = (Project) session.get(Project.class, id);
            return project;
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
    public void update(Project project, long id) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            Project proxyProject = (Project) session.get(Project.class, id);
            proxyProject.setName(project.getName());
            proxyProject.setCost(project.getCost());
            proxyProject.setDevelopers(project.getDevelopers());
            session.update(proxyProject);
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
        session.createSQLQuery("DELETE FROM proj_dev WHERE id_proj = " + id).executeUpdate();
        session.createSQLQuery("DELETE FROM cust_proj WHERE id_proj = " + id).executeUpdate();
        session.createSQLQuery("DELETE FROM comp_proj WHERE id_proj = " + id).executeUpdate();
        try {
            Project project = (Project) session.load(Project.class, id);
            session.delete(project);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            tx.commit();
            session.close();
        }
    }

    @Override
    public List<Project> findByName(String nameProject) {
        return null;
    }

    @Override
    public List<Project> findByCost(int cost) {
        return null;
    }

    public Set<Project> getAll() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            return new HashSet<>(session.createQuery("FROM Project").list());
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            tx.commit();
            session.close();
        }
        return Collections.emptySet();
    }
}
