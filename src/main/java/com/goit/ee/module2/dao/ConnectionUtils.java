package com.goit.ee.module2.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionUtils {

    public static String url = "jdbc:postgresql://localhost:5432/postgres";
    public static String user = "usonic";
    public static String password = "123";
    static final String JDBC_DRIVER = "org.postgresql.Driver";

    public static void loaderAndConnection() {
        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("the driver is successfully connected");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}






