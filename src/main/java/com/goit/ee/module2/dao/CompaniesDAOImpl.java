package com.goit.ee.module2.dao;

import com.goit.ee.module2.dto.Company;
import com.goit.ee.module2.dto.Developer;

import java.sql.*;

/**
 * Created by Alex on 04.12.2016.
 */
public class CompaniesDAOImpl implements CompaniesDAO {
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
            output = "ID------Name-------Address\n";
            while (rs.next()) {

                int id = rs.getInt("id");
                String name = rs.getString("name");
                String address = rs.getString("address");
                output = output + id + "-----" + name + "-----" + address + "\n";
            }
        } finally {
            rs.close();
        }
        return output;
    }

    public boolean create(Company company) {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("INSERT INTO companies (name, address) VALUES (?, ?)");
            ps.setString(1, company.getName());
            ps.setString(2, company.getAddress());
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
            PreparedStatement ps = connection.prepareStatement("SELECT * from companies WHERE id = ?");
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

    public boolean update(Company company) {
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE companies " +
                    "set name=?, address=?" +
                    " WHERE id=?");
            ps.setString(1, company.getName());
            ps.setString(2, company.getAddress());
            ps.setLong(3, company.getId());
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
            ps = connection.prepareStatement("DELETE FROM companies WHERE id=?");
            ps.setLong(1, id);
            int delResult;
            try {
                delResult = ps.executeUpdate();
                if (delResult == 1) {
                    System.out.println("Entry was deleted from DB.");
                    showAllData();
                    return true;
                } else System.out.println("Entry not found");
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
            PreparedStatement ps = connection.prepareStatement("SELECT * from companies WHERE name = ?");
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

    public void showAllData() {
        Statement statement=null;
        try {
           statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * from companies ORDER BY id");
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
