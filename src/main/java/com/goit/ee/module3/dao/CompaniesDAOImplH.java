package com.goit.ee.module3.dao;

import com.goit.ee.module3.dto.Company;
import com.goit.ee.module3.util.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CompaniesDAOImplH implements CompaniesDAO {

    @Override
    public void create(Company company) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
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
            return session.load(Company.class, id);
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
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            Company company1 = session.load(Company.class, id);
            company1.setName(company.getName());
            company1.setAddress(company.getAddress());
            company1.setProjects(company.getProjects());
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

    }

    @Override
    public boolean findByName(String name) {
        return false;
    }

    public List getAll() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        return session.createQuery("select c from Company c").list();
    }
}
