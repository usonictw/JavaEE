package com.goit.ee.module2.dao;

import com.goit.ee.module2.dto.Developer;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 18.12.2016.
 */
public class DevelopersDAOImplH implements DevelopersDAO {

    private Session session;

    @Override
    public boolean create(Developer developer) {
        return false;
    }

    @Override
    public boolean get(long id) {
        return false;
    }

    @Override
    public boolean update(Developer developer) {
        return false;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }

    @Override
    public boolean findByName(String name) {
        return false;
    }

    @Override
    public boolean findByNameAndLastName(String name, String lastName) {
        return false;
    }

    public List getAll(){

        return session.createSQLQuery("SELECT  * FROM developers").list();
    }

    public void setSession(Session session) {
        this.session = session;
    }
}
