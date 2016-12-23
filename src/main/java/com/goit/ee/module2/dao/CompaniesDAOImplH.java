package com.goit.ee.module2.dao;

import com.goit.ee.module2.dto.Company;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CompaniesDAOImplH implements CompaniesDAO {

    private Session session;

    @Override
    public void create(Company company) {

    }

    @Override
    public Company get(long id) {
        return null;
    }

    @Override
    public void update(Company company) {

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
