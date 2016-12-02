package com.goit.ee.module2.dao;
import com.goit.ee.module2.dto.Project;
import java.sql.*;
import java.util.List;

public class ProjectDAOImpl implements ProjectsDAO {

    ConnectedUtil connectedUtil = new ConnectedUtil();

    @Override
    public void create(Project pr) {
        PreparedStatement preparedStatement = null;
        String query = "INSERT INTO projects(name, cost) VALUES (?,?)";
        try {
            preparedStatement = connectedUtil.getConnection().prepareStatement(query);
            preparedStatement.setString(1, pr.getName());
            preparedStatement.setInt(2, pr.getCost());
            preparedStatement.executeUpdate();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    @Override
    public List<Project> read(Project project) {


        return null;
    }

    @Override
    public void update(Project project) {

    }

    @Override
    public void delete(Project pr) {
        PreparedStatement preparedStatement = null;
        String query = "DELETE FROM projects WHERE name = ?";
        try {
            preparedStatement = connectedUtil.getConnection().prepareStatement(query);
            preparedStatement.setString(1, pr.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

    }

    @Override
    public void findByName(String nameProject) {

    }

    public static void main(String[] args) {


    Project project = new Project(2, "Proj1", 2000);

        ProjectDAOImpl projectDAO = new ProjectDAOImpl();
        projectDAO.delete(project);
    }
}
