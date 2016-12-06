package com.goit.ee.module2.dao;
import com.goit.ee.module2.dto.Customer;
import com.goit.ee.module2.dto.Customer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {

    ConnectedUtil connectedUtil = new ConnectedUtil();
    private static final String id = "id";
    private static final String name = "name";
    private static final String address = "address";

    private String selectAll = "SELECT * FROM projects";
    private String queryInsert = "INSERT INTO projects(name, cost) VALUES (?,?)";
    private String selectById = "SELECT * FROM projects WHERE id = ?";
    private String deleteByID = "DELETE FROM projects WHERE id = ?";
    private String update = "UPDATE projects SET name = ?, cost = ? WHERE id = ?";
    private String selectByName = "SELECT * FROM projects WHERE name = ?";
    private String selectByCost = "SELECT * FROM projects WHERE cost = ?";

    public List<Customer> getAll() {
        List<Customer> customerList = new ArrayList<>();
        String queryRead = "SELECT * FROM Customers";
        try (Statement statement = connectedUtil.getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery(queryRead);
            while (resultSet.next()) {
                customerList.add(new Customer(resultSet.getInt(id),
                        resultSet.getString(name),
                        resultSet.getString(address)));
            }
        } catch (SQLException e) {
            System.out.println("query SQL error");
        }
        return customerList;
    }

    @Override
    public boolean create(Customer customer) {
        boolean flag = false;
        if (customer != null) {
            String query = "INSERT INTO Customers(name, address) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = connectedUtil.getConnection().prepareStatement(query)) {
                preparedStatement.setString(1, customer.getName());
                preparedStatement.setString(2, customer.getAddress());
                int count = preparedStatement.executeUpdate();
                if (count == 1) {
                    System.out.println("The Customer added to DB successful");
                    getAll().forEach(System.out::println);
                    flag = true;
                }
            } catch (SQLException e1) {
                System.out.println("query SQL error");
            }
            return flag;
        } else {
            System.out.println("Customers's name is NULL");
            return flag;
        }
    }

    @Override
    public boolean get(long id) {
        boolean flag = false;
        if (id != 0) {
            String query = "SELECT * FROM Customers WHERE id = ?";
            try (PreparedStatement preparedStatement = connectedUtil.getConnection().prepareStatement(query)) {
                preparedStatement.setLong(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    System.out.println(new Customer(resultSet.getInt(id),
                            resultSet.getString(name),
                            resultSet.getString(address)));
                    flag = true;
                }
            } catch (SQLException e) {
                System.out.println("query SQL error");
            }
            return flag;
        } else {
            System.out.println("ID parameter can not be 0");
            return flag;
        }
    }

    @Override
    public boolean delete(long id) {
        boolean flag = false;
        if (id != 0) {
            String query = "DELETE FROM Customers WHERE id = ?";
            try (PreparedStatement preparedStatement = connectedUtil.getConnection().prepareStatement(query)) {
                preparedStatement.setLong(1, id);
                int count = preparedStatement.executeUpdate();
                if (count == 1) {
                    getAll().forEach(System.out::println);
                    flag = true;
                }
            } catch (SQLException e) {
                System.out.println("query SQL error");
            }
            return flag;
        } else {
            System.out.println("ID parameter can not be 0");
            return flag;
        }
    }

    @Override
    public boolean update(Customer pr) {
        boolean flag = false;
        if (pr != null) {
            String query = "UPDATE Customers SET name = ? WHERE id = ?";
            try (PreparedStatement preparedStatement = connectedUtil.getConnection().prepareStatement(query)) {
                preparedStatement.setString(1, pr.getName());
                preparedStatement.setLong(2, pr.getId());
                int count = preparedStatement.executeUpdate();
                if (count == 1) {
                    System.out.println("The Customer added to DB successful");
                    getAll().forEach(System.out::println);
                    flag = true;
                }
            } catch (SQLException e1) {
                System.out.println("query SQL error");
            }
            return flag;
        } else {
            System.out.println("the Customers can not be NULL");
            return flag;
        }
    }

    @Override
    public List<Customer> findByName(String nameCustomer) {
        List<Customer> customerList = new ArrayList<>();
        if (nameCustomer != null) {
            String queryFind = "SELECT * FROM Customers WHERE name = ?";
            try (PreparedStatement preparedStatement = connectedUtil.getConnection().prepareStatement(queryFind)) {
                preparedStatement.setString(1, nameCustomer);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (!resultSet.next()) {
                    System.out.println("Customer's name not found");
                }
                while (resultSet.next()) {
                    customerList.add(new Customer(resultSet.getInt(id),
                            resultSet.getString("name")));
                }
            } catch (SQLException e1) {
                System.out.println("query SQL error");
            }
            return customerList;
        } else {
            System.out.println("Customer name can not NULL");
            return customerList;
        }
    }

    @Override
    public List<Customer> findByAddress(String addressCustomer) {
        List<Customer> customerList = new ArrayList<>();
        if (addressCustomer != null) {
            String queryFind = "SELECT * FROM Customers WHERE address = ?";
            try (PreparedStatement preparedStatement = connectedUtil.getConnection().prepareStatement(queryFind)) {
                preparedStatement.setString(1, addressCustomer);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (!resultSet.next()) {
                    System.out.println("Customer's address not found");
                }
                while (resultSet.next()) {
                    customerList.add(new Customer(resultSet.getInt(id),
                            resultSet.getString(name)));
                }
            } catch (SQLException e1) {
                System.out.println("query SQL error");
            }
            return customerList;
        } else {
            System.out.println("Customer address can not NULL");
            return customerList;
        }
    }
}



