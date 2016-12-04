package com.goit.ee.module2.dao;

import com.goit.ee.module2.dto.Developer;

import java.sql.*;

/**
 * Created by Alex on 04.12.2016.
 */
public class DeveloperDAOImpl implements DevelopersDAO {
    private static Connection connection;

    static {
        String url = "jdbc:postgresql://localhost:5432/goit";
        String user = "postgres";
        String password = "111";
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private String printingResultSet(ResultSet rs) throws SQLException {
        String output;

        try {
            output = "ID------First_Name-------LastName--------Age\n";
            while (rs.next()) {

                int id = rs.getInt("id");
                String first_name = rs.getString("first_name");
                String last_name = rs.getString("last_name");
                int age = rs.getInt("age");
                output = output + id + "-----" + first_name + "-----" + last_name + "-----" + age + "\n";
            }
        } finally {
            rs.close();
        }
        return output;
    }


    public boolean create(Developer developer) {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("INSERT INTO developers (first_name, last_name, age) VALUES (?, ?,?)");
            ps.setString(1,developer.getFirstName());
            ps.setString(2,developer.getLastName());
            ps.setInt(3,developer.getAge());
            int updResult = ps.executeUpdate();
            System.out.println(updResult+" entry(s) was(were) added to DB");
            showAllData();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;


        //INSERT INTO developers (first_name, last_name, age) VALUES ('Leolani', 'Richey', 25),
    }

    public boolean get(long id) {
        return false;
    }

    public boolean update(Developer developer) {
        return false;
    }

    public boolean delete(long id) {
        return false;
    }

    public void findByName(String name) {
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * from developers WHERE first_name = ?");
            ps.setString(1, name);
            ResultSet resultSet = ps.executeQuery();
            String output = "ID------First_Name-------LastName--------Age\n";
            System.out.println(printingResultSet(resultSet));
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void findByNameAndLastName(String name, String lastName) {
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * from developers WHERE first_name = ? and last_name=?");
            ps.setString(1, name);
            ps.setString(2, lastName);
            ResultSet resultSet = ps.executeQuery();
            String output = "ID------First_Name-------LastName--------Age\n";
            System.out.println(printingResultSet(resultSet));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void showAllData() {
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * from developers");
            System.out.println(printingResultSet(rs));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
