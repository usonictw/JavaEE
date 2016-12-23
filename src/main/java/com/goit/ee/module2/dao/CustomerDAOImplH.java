package com.goit.ee.module2.dao;

import com.goit.ee.module2.dto.Customer;
import org.hibernate.Session;

import java.util.List;

public class CustomerDAOImplH implements CustomerDAO {

    private Session session;

    @Override
    public void create(Customer customer) {

    }

    @Override
    public Customer get(long id) {
        return null;
    }

    @Override
    public void update(Customer customer) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public List<Customer> findByName(String name) {
        return null;
    }

    @Override
    public List<Customer> findByAddress(String address) {
        return null;
    }

    public List<Customer> getAll(){

        return session.createQuery("select cust from Customer cust").list();
    }
}
