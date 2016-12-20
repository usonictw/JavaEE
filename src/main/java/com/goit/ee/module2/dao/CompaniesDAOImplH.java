package com.goit.ee.module2.dao;

import com.goit.ee.module2.dto.Company;
import org.hibernate.Session;

/**
 * Created by user on 20.12.2016.
 */
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
}
