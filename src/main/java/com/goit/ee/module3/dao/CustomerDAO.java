package com.goit.ee.module3.dao;

import com.goit.ee.module3.dto.Customer;

import java.util.List;

public interface CustomerDAO extends DAO<Customer> {

    List<Customer> findByName(String name);
    List<Customer> findByAddress(String address);
}
