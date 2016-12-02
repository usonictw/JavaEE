package com.goit.ee.module2.dao;


/**
 * Created by PC on 01.12.2016.
 */
public interface ProjectsDAO extends DAO {

    void findByName(String nameProject);

}
