package com.goit.ee.module2.dao;

import com.goit.ee.module2.dto.Customer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by PC on 04.12.2016.
 */
public class CustomerDAOImpl implements CustomerDAO {

    ConnectedUtil connectedUtil = new ConnectedUtil();


    @Override
    public void create(Customer customer) {
        if (customer != null) {
            String query = "INSERT INTO customer (name, address) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = connectedUtil.getConnection().prepareStatement(query)) {
                preparedStatement.setString(1, customer.getName());
                preparedStatement.setString(2, customer.getAddress());
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Customer can not be NULL");
        }

    }

    @Override
    public List<Customer> read() {
        List<Customer> customerList = new ArrayList<>();
        String query = "SELECT * FROM customer";
        try (PreparedStatement preparedStatement = connectedUtil.getConnection().prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
               customerList.add(new Customer(resultSet.getInt("id"), resultSet.getString("name"),
                       resultSet.getString("address")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customerList;
    }

    @Override
    public void update(Customer customer) {
        String query = "update customer set name = ?, addresss = ? where id = ?";
        try(PreparedStatement preparedStatement = connectedUtil.getConnection().prepareStatement(query)) {
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(Customer customer) {

    }

    @Override
    public List<Customer> findByName(String name) {
        return null;
    }

    @Override
    public List<Customer> findByAddress(String address) {
        return null;
    }
}
