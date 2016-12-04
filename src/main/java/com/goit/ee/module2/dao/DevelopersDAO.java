package com.goit.ee.module2.dao;

import com.goit.ee.module2.dto.Developer;

/**
 * Created by Alex on 04.12.2016.
 */

//    Create DevelopersDAO interface that implement DAO and also add method specific for the developer table, like:
//    findByName(String name),
//    findByNameAndLastName(String name,
//                          String lastName).
//
//    Create DevelopersDAOImpl class which implements DeveloperDAO interface and implement all methods using JDBC.

public interface DevelopersDAO extends DAO<Developer> {
    boolean findByName(String name);
    boolean findByNameAndLastName(String name, String lastName);
}
