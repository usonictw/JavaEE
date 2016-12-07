package com.goit.ee.module2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectedUtil {

    private static final String url = "jdbc:postgresql://localhost:5432/module1";
    private static final String user = "usonic";
    private static final String password = "123";
    private static final String driver = "org.postgresql.Driver";
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

    public static void main(String[] args) {

        ConnectedUtil connectedUtil = new ConnectedUtil();
    }

}
