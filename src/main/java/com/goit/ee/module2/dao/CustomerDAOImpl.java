package com.goit.ee.module2.dao;

import com.goit.ee.module2.dto.Customer;
import com.goit.ee.module2.dto.Customer;
import com.goit.ee.module2.dto.Skill;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {

    ConnectedUtil connectedUtil = new ConnectedUtil();
    private static final String columnId = "id";
    private static final String columnName = "name";
    private static final String columnAddress = "address";

    private String selectAll = "SELECT * FROM customers";
    private String queryInsert = "INSERT INTO customers(name, address) VALUES (?,?)";
    private String selectById = "SELECT * FROM customers WHERE id = ?";
    private String deleteById = "DELETE FROM customers WHERE id = ?";
    private String update = "UPDATE customers SET name = ?, address = ? WHERE id = ?";
    private String selectByName = "SELECT * FROM customers WHERE name = ?";
    private String selectByAddress = "SELECT * FROM customers WHERE address = ?";

    public List<Customer> getAll() {
        List<Customer> customerList = new ArrayList<>();
        try (Statement statement = connectedUtil.getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery(selectAll);
            while (resultSet.next()) {
                customerList.add(new Customer(resultSet.getInt(columnId),
                        resultSet.getString(columnName),
                        resultSet.getString(columnAddress)));
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
            try (PreparedStatement preparedStatement = connectedUtil.getConnection().prepareStatement(queryInsert)) {
                preparedStatement.setString(1, customer.getName());
                preparedStatement.setString(2, customer.getAddress());
                int count = preparedStatement.executeUpdate();
                if (count == 1) {
                    getAll().forEach(System.out::println);
                    flag = true;
                }
            } catch (SQLException e1) {
                System.out.println("query SQL error");
            }
        }
        return flag;
    }

    @Override
    public boolean get(long id) {
        boolean flag = false;
        if (id != 0) {
            try (PreparedStatement preparedStatement = connectedUtil.getConnection().prepareStatement(selectById)) {
                preparedStatement.setLong(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    System.out.println(new Customer(resultSet.getInt(columnId),
                            resultSet.getString(columnName),
                            resultSet.getString(columnAddress)));
                    flag = true;
                }
            } catch (SQLException e) {
                System.out.println("query SQL error");
            }
        }
        return flag;
    }

    @Override
    public boolean delete(long id) {
        boolean flag = false;
        if (id != 0) {
            try (PreparedStatement preparedStatement = connectedUtil.getConnection().prepareStatement(deleteById)) {
                preparedStatement.setLong(1, id);
                int count = preparedStatement.executeUpdate();
                if (count == 1) {
                    getAll().forEach(System.out::println);
                    flag = true;
                }
            } catch (SQLException e) {
                System.out.println("query SQL error");
            }
        }
        return flag;
    }

    @Override
    public boolean update(Customer pr) {
        boolean flag = false;
        if (pr != null) {
            try (PreparedStatement preparedStatement = connectedUtil.getConnection().prepareStatement(update)) {
                preparedStatement.setString(1, pr.getName());
                preparedStatement.setLong(2, pr.getId());
                int count = preparedStatement.executeUpdate();
                if (count == 1) {
                    getAll().forEach(System.out::println);
                    flag = true;
                }
            } catch (SQLException e1) {
                System.out.println("query SQL error");
            }
        }
        return flag;
    }

    @Override
    public List<Customer> findByName(String nameCustomer) {
        List<Customer> customerList = new ArrayList<>();
        if (nameCustomer != null) {
            try (PreparedStatement preparedStatement = connectedUtil.getConnection().prepareStatement(selectByName)) {
                preparedStatement.setString(1, nameCustomer);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    customerList.add(new Customer(resultSet.getInt(columnId),
                            resultSet.getString(columnName),
                            resultSet.getString(columnAddress)));
                }
            } catch (SQLException e1) {
                System.out.println("query SQL error");
            }
        }
        return customerList;
    }

    @Override
    public List<Customer> findByAddress(String addressCustomer) {
        List<Customer> customerList = new ArrayList<>();
        if (addressCustomer != null) {
            try (PreparedStatement preparedStatement = connectedUtil.getConnection().prepareStatement(selectByAddress)) {
                preparedStatement.setString(1, addressCustomer);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    customerList.add(new Customer(resultSet.getLong(columnId),
                            resultSet.getString(columnName),
                            resultSet.getString(columnAddress)));
                }
            } catch (SQLException e1) {
                System.out.println("query SQL error");
            }
        }
        return customerList;
    }
}


