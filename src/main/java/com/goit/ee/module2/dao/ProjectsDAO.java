package com.goit.ee.module2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by user on 01.12.2016.
 */
public class ProjectsDAO implements DAO {


    public List<Project> getAll(){

        ConnectionUtils.loaderAndConnection();
        try {
            Connection connection = DriverManager.getConnection(ConnectionUtils.url, ConnectionUtils.user, ConnectionUtils.password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void create(Project pr){

    }
   /* get(long id)
    update(T t)
    delete(long id)
    */
}
