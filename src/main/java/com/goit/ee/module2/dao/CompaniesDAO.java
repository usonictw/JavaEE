package com.goit.ee.module2.dao;

import com.goit.ee.module2.dto.Company;

/**
 * Created by Alex on 04.12.2016.
 */

public interface CompaniesDAO extends DAO<Company> {
    boolean findByName(String name);
}
