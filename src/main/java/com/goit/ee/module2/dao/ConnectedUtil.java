package com.goit.ee.module2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by PC on 01.12.2016.
 */
public class ConnectedUtil {

    private final String url = "jdbc:postgresql://localhost:5432/postgres";
    private final String user = "usonic";
    private final String password = "123";
    private final String driver = "org.postgresql.Driver";
    private Connection connection;

    public ConnectedUtil() {
        try {
            Class.forName(driver);
            System.out.println("the driver successfully connected");
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("connection to DB successful");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
