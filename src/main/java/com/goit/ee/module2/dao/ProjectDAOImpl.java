package com.goit.ee.module2.dao;
import com.goit.ee.module2.dto.Project;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProjectDAOImpl implements ProjectsDAO {

    ConnectedUtil connectedUtil = new ConnectedUtil();

    public List<Project> getAll() {
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
    public boolean create(Project pr) {
        boolean flag = false;
        if (pr != null) {
            String query = "INSERT INTO projects(name, cost) VALUES (?,?)";
            try (PreparedStatement preparedStatement = connectedUtil.getConnection().prepareStatement(query)) {
                preparedStatement.setString(1, pr.getName());
                preparedStatement.setInt(2, pr.getCost());
                int count = preparedStatement.executeUpdate();
                if (count == 1) {
                    System.out.println("The Project added to DB successful");
                    getAll().forEach(System.out::println);
                    flag = true;
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            return flag;
        } else {
            System.out.println("projects's name is NULL");
            return flag;
        }
    }

    @Override
    public boolean get(long id) {
        boolean flag = false;
        if (id != 0) {
            String query = "SELECT * FROM projects WHERE id = ?";
            try (PreparedStatement preparedStatement = connectedUtil.getConnection().prepareStatement(query)) {
                preparedStatement.setLong(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    System.out.println(new Project(resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getInt("cost")));
                    flag = true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
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
            String query = "DELETE FROM projects WHERE id = ?";
            try (PreparedStatement preparedStatement = connectedUtil.getConnection().prepareStatement(query)) {
                preparedStatement.setLong(1, id);
                int count = preparedStatement.executeUpdate();
                if (count == 1) {
                    getAll().forEach(System.out::println);
                    flag = true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return flag;
        } else {
            System.out.println("ID parameter can not be 0");
            return flag;
        }
    }

    @Override
    public boolean update(Project pr) {
        boolean flag = false;
        if (pr != null) {
            String query = "UPDATE projects SET name = ?, cost = ? WHERE id = ?";
            try (PreparedStatement preparedStatement = connectedUtil.getConnection().prepareStatement(query)) {
                preparedStatement.setString(1, pr.getName());
                preparedStatement.setInt(2, pr.getCost());
                preparedStatement.setLong(3, pr.getId());
                int count = preparedStatement.executeUpdate();
                if (count == 1) {
                    System.out.println("The Project added to DB successful");
                    getAll().forEach(System.out::println);
                    flag = true;
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            return flag;
        } else {
            System.out.println("the projects can not be NULL");
            return flag;
        }
    }

    @Override
    public List<Project> findByName(String nameProject) {
        List<Project> projectList = new ArrayList<>();
        if (nameProject != null) {
            String queryFind = "SELECT * FROM projects WHERE name = ?";
            try (PreparedStatement preparedStatement = connectedUtil.getConnection().prepareStatement(queryFind)) {
                preparedStatement.setString(1, nameProject);
                ResultSet resultSet = preparedStatement.executeQuery();
                if(!resultSet.next()) {
                    System.out.println("Project's name not found");
                }
                while (resultSet.next()) {
                    projectList.add(new Project(resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getInt("cost")));
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            return projectList;
        } else {
            System.out.println("Project name can not NULL");
            return projectList;
        }
    }

    @Override
    public List<Project> findByCost(int cost) {
        List<Project> projectList = new ArrayList<>();
        if(cost != 0) {
            String queryFind = "SELECT * FROM projects WHERE cost = ?";
            try (PreparedStatement preparedStatement = connectedUtil.getConnection().prepareStatement(queryFind)) {
                preparedStatement.setInt(1, cost);
                ResultSet resultSet = preparedStatement.executeQuery();
                if(!resultSet.next()) {
                    System.out.println("Project's cost not found");
                }
                while (resultSet.next()) {
                    projectList.add(new Project(resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getInt("cost")));
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            return projectList;
        }else {
            System.out.println("Project cost can not be 0");
            return projectList;
        }
    }

    public static void main(String[] args) {
        ProjectDAOImpl projectDAO = new ProjectDAOImpl();

        Project project = new Project(1, "proj2", 30000);
       // projectDAO.getAll().forEach(System.out::println);
        System.out.println(projectDAO.findByName("Qr Scan1"));
    }
}
