package com.goit.ee.module2.dao;

import com.goit.ee.module2.dto.Company;

public interface CompaniesDAO extends DAO<Company> {
    boolean findByName(String name);
}
