package com.goit.ee.module2.dao;

import com.goit.ee.module2.dto.Developer;

import java.sql.*;

/**
 * Created by Alex on 04.12.2016.
 */
public class DeveloperDAOImpl implements DevelopersDAO {
    private static Connection connection;

    static {
        String url = "jdbc:postgresql://localhost:5432/module1";
        String user = "usonic";
        String password = "123";
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
            output = "ID------First_Name-------LastName--------Age-------Salary\n";
            while (rs.next()) {

                int id = rs.getInt("id");
                String first_name = rs.getString("first_name");
                String last_name = rs.getString("last_name");
                int age = rs.getInt("age");
                double salary = rs.getDouble("salary");
                output = output + id + "-----" + first_name + "-----" + last_name + "-----" + age + "------" + salary + "\n";
            }
        } finally {
            rs.close();
        }
        return output;
    }

    public boolean create(Developer developer) {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("INSERT INTO developers (first_name, last_name, age,salary) VALUES (?, ?,?,?)");
            ps.setString(1, developer.getFirstName());
            ps.setString(2, developer.getLastName());
            ps.setInt(3, developer.getAge());
            ps.setDouble(4, developer.getSalary());
            if (ps.executeUpdate() == 1) {
                System.out.println("Entry was successfully added to DB");
                showAllData();
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean get(long id) {
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * from developers WHERE id = ?");
            ps.setLong(1, id);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet != null) {
                System.out.println(("Record with ID = " + id + " found"));
                System.out.println(printingResultSet(resultSet));
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean update(Developer developer) {
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE developers " +
                    "set first_name=?, last_name=?, age=?, salary=?" +
                    " WHERE id=?");
            ps.setString(1, developer.getFirstName());
            ps.setString(2, developer.getLastName());
            ps.setInt(3, developer.getAge());
            ps.setDouble(4, developer.getSalary());
            ps.setLong(5, developer.getId());
            if (ps.executeUpdate() == 1) {
                System.out.println("Entry was found and updated.");
                showAllData();
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(long id) {
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement("DELETE FROM developers WHERE id=?");
            ps.setLong(1, id);
            int delResult;
            try {
                delResult = ps.executeUpdate();
                if (delResult == 1) {
                    System.out.println("Entry was deleted from DB.");
                    showAllData();
                    return true;
                } else System.out.println("Not found entry");
            } catch (SQLException e) {
                System.out.println("Failure in deleting entry");
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean findByName(String name) {
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * from developers WHERE first_name = ?");
            ps.setString(1, name);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet != null) {
                System.out.println("Entry(s) with Name = " + name + " was found");
                System.out.println(printingResultSet(resultSet));
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean findByNameAndLastName(String name, String lastName) {
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * from developers WHERE first_name = ? and last_name=?");
            ps.setString(1, name);
            ps.setString(2, lastName);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet != null) {
                System.out.println("Entry(s) with Name = " + name + " and Last Name ="+lastName+" was found");
                System.out.println(printingResultSet(resultSet));
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void showAllData() {
        Statement statement=null;
        try {
           statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * from developers ORDER BY id");
            System.out.println(printingResultSet(rs));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
