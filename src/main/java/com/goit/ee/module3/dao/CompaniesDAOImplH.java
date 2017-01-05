package com.goit.ee.module3.dao;

import com.goit.ee.module3.dto.Company;
import com.goit.ee.module3.dto.Project;
import com.goit.ee.module3.util.HibernateSessionFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.*;

import static com.goit.ee.module3.contoller.ConsoleUtils.getParam;

public class CompaniesDAOImplH implements CompaniesDAO {

    @Override
    public void create(Company company) {
        ProjectDAOImplH projectDAOImplH = new ProjectDAOImplH();
        Set<Project> projectSet = new HashSet<>();
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            long numberProjects;
            projectDAOImplH.getAll().forEach(System.out::println);
            numberProjects = getParam("number of project");
            for (int i = 0; i < numberProjects; i++) {
                projectSet.add((Project) session.get(Project.class, getParam("id of project")));
            }
            company.setProjects(projectSet);
            session.save(company);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.getTransaction().commit();
            session.close();
        }
    }

    @Override
    public Company get(long id) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            return (Company) session.get(Company.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.getTransaction().commit();
            session.close();
        }
        return null;
    }

    @Override
    public void update(Company company, long id) {
        ProjectDAOImplH projectDAOImplH = new ProjectDAOImplH();
        Set<Project> projectSet = new HashSet<>();
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            Company company1 = (Company) session.load(Company.class, id);
            company1.setName(company.getName());
            company1.setAddress(company.getAddress());
            long numberProjects;
            projectDAOImplH.getAll().forEach(System.out::println);
            numberProjects = getParam("number of project");
            for (int i = 0; i < numberProjects; i++) {
                projectSet.add((Project) session.get(Project.class, getParam("id of project")));
            }
            company1.setProjects(projectSet);
            session.update(company1);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.getTransaction().commit();
            session.close();
        }

    }

    @Override
    public void delete(long id) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        try {
            session.createSQLQuery("DELETE FROM comp_proj WHERE id_comp = " + id).executeUpdate();
            Company company = (Company) session.load(Company.class, id);
            session.delete(company);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.getTransaction().commit();
            session.close();
        }
    }

    @Override
    public boolean findByName(String name) {
        return false;
    }

    public Set<Company> getAll() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            return new HashSet<>(session.createQuery("select c from Company c").list());
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.getTransaction().commit();
            session.close();
        }
        return Collections.EMPTY_SET;
    }
}
