package com.goit.ee.module3.dao;

import com.goit.ee.module3.dto.Company;

public interface CompaniesDAO extends DAO<Company> {
    boolean findByName(String name);
}
