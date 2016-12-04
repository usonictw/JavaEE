package com.goit.ee.module2.dao;

import com.goit.ee.module2.dto.Project;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectDAOImpl implements ProjectsDAO {

    ConnectedUtil connectedUtil = new ConnectedUtil();

    private void preparedStatement(String name, int cost, String query) {
        try (PreparedStatement preparedStatement = connectedUtil.getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, cost);
            preparedStatement.executeUpdate();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    @Override
    public void create(Project pr) {
        if (pr != null) {
            String query = "INSERT INTO module1.public.projects(name, cost) VALUES (?,?)";
            preparedStatement(pr.getName(), pr.getCost(), query);
        } else {
            System.out.println("projects's name is NULL");
        }
    }

    @Override
    public List<Project> read() {
        List<Project> projectList = new ArrayList<>();
        String queryRead = "SELECT * FROM projects";
        try (Statement statement = connectedUtil.getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery(queryRead);
            while (resultSet.next()) {
                projectList.add(new Project(resultSet.getInt("id"),
                        resultSet.getString("name"), resultSet.getInt("cost")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return projectList;
    }

    @Override
    public void update(Project pr) {
        String query = "UPDATE projects SET name = ?, cost = ? WHERE id = ?";
        preparedStatement(pr.getName(), pr.getCost(), query);
    }

    @Override
    public void delete(Project pr) {
        String query = "DELETE FROM projects WHERE name = ? OR cost = ?";
        preparedStatement(pr.getName(), pr.getCost(), query);
    }

    @Override
    public List<Project> findByName(String nameProject) {
        List<Project> projectList = new ArrayList<>();
        String queryFind = "SELECT * FROM projects WHERE name = ?";
        try (PreparedStatement preparedStatement = connectedUtil.getConnection().prepareStatement(queryFind)) {
            preparedStatement.setString(1, nameProject);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                projectList.add(new Project(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("cost")));
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return projectList;
    }

    @Override
    public List<Project> findByCost(int cost) {
        List<Project> projectList = new ArrayList<>();
        String queryFind = "SELECT * FROM projects WHERE cost = ?";
        try (PreparedStatement preparedStatement = connectedUtil.getConnection().prepareStatement(queryFind)) {
            preparedStatement.setInt(1, cost);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                projectList.add(new Project(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("cost")));
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return projectList;
    }
}
