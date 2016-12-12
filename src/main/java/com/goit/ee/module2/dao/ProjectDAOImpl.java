package com.goit.ee.module2.dao;

import com.goit.ee.module2.dto.Project;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProjectDAOImpl implements ProjectsDAO {

    private ConnectedUtil connectedUtil = new ConnectedUtil();
    public static final String id = "id";
    public static final String name = "name";
    public static final String cost = "cost";

    private String selectAll = "SELECT * FROM projects";
    private String queryInsert = "INSERT INTO projects(name, cost) VALUES (?,?)";
    private String selectById = "SELECT * FROM projects WHERE id = ?";
    private String deleteById = "DELETE FROM projects WHERE id = ?";
    private String update = "UPDATE projects SET name = ?, cost = ? WHERE id = ?";
    private String selectByName = "SELECT * FROM projects WHERE name = ?";
    private String selectByCost = "SELECT * FROM projects WHERE cost = ?";

    public List<Project> getAll() {
        List<Project> projectList = new ArrayList<>();

        try (Statement statement = connectedUtil.getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery(selectAll);
            while (resultSet.next()) {
                projectList.add(new Project(resultSet.getInt(id),
                        resultSet.getString(name), resultSet.getInt(cost)));
            }
        } catch (SQLException e) {
            System.out.println("Projects table not found");
        }
        return projectList;
    }

    @Override
    public boolean create(Project pr) {
        boolean flag = false;
        if (pr != null) {
            try (PreparedStatement preparedStatement = connectedUtil.getConnection().prepareStatement(queryInsert)) {
                preparedStatement.setString(1, pr.getName());
                preparedStatement.setInt(2, pr.getCost());
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
                    System.out.println(new Project(resultSet.getInt("id"),
                            resultSet.getString(name),
                            resultSet.getInt(cost)));
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
                    flag = true;
                }
            } catch (SQLException e) {
                System.out.println("query SQL error");
            }
        }
        return flag;
    }

    @Override
    public boolean update(Project pr) {
        boolean flag = false;
        if (pr != null) {
            try (PreparedStatement preparedStatement = connectedUtil.getConnection().prepareStatement(update)) {
                preparedStatement.setString(1, pr.getName());
                preparedStatement.setInt(2, pr.getCost());
                preparedStatement.setLong(3, pr.getId());
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
    public List<Project> findByName(String nameProject) {
        List<Project> projectList = new ArrayList<>();
        if (nameProject != null) {
            try (PreparedStatement preparedStatement = connectedUtil.getConnection().prepareStatement(selectByName)) {
                preparedStatement.setString(1, nameProject);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    projectList.add(new Project(resultSet.getInt(id),
                            resultSet.getString(name),
                            resultSet.getInt(cost)));
                }
            } catch (SQLException e1) {
                System.out.println("query SQL error");
            }
            return projectList;
        }
        return projectList;
    }

    @Override
    public List<Project> findByCost(int cost) {
        List<Project> projectList = new ArrayList<>();
        if (cost != 0) {
            try (PreparedStatement preparedStatement = connectedUtil.getConnection().prepareStatement(selectByCost)) {
                preparedStatement.setInt(1, cost);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    projectList.add(new Project(resultSet.getInt(id),
                            resultSet.getString(name),
                            resultSet.getInt(cost)));
                }
            } catch (SQLException e1) {
                System.out.println("query SQL error");
            }
        }
        return projectList;
    }
}
