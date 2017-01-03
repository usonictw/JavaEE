package com.goit.ee.module3.dao;

import com.goit.ee.module3.dto.Company;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CompaniesDAOImplH implements CompaniesDAO {

    private Session session;

    @Override
    public void create(Company company) {
        Transaction tx = session.beginTransaction();
        try {
            session.save(company);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            tx.commit();
            session.close();
        }

    }

    @Override
    public Company get(long id) {
        Transaction tx = session.beginTransaction();
        Object persisntanceIntance = session.load(Company.class, id);
        return (Company) persisntanceIntance;
    }

    @Override
    public void update(Company company, long id) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public boolean findByName(String name) {
        return false;
    }

    public List getAll() {
        Transaction tx = session.beginTransaction();
        return session.createQuery("select c from Company c").list();
    }

    public void setSession(Session session) {
        this.session = session;
    }
}
