package com.goit.ee.module2.dao;
import com.goit.ee.module2.dto.Skill;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SkillsDAOImpl implements SkillsDAO {

    ConnectedUtil connectedUtil = new ConnectedUtil();

    @Override
    public void create(Skill skill) {
        if (skill != null) {
            String quweryCreate = "INSERT INTO module1.public.skills (name) VALUES (?)";
            try (PreparedStatement preparedStatement = connectedUtil.getConnection().prepareStatement(quweryCreate)) {
                preparedStatement.setString(1, skill.getName());
                int flag = preparedStatement.executeUpdate();
                if (flag == 1) {
                    System.out.println("Skiil's name added to DB");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("error. Skill can not be NULL");
        }
    }

    @Override
    public List<Skill> read() {
        List<Skill> skillList = new ArrayList<>();
        String queryRead = "SELECT * FROM projects";
        try (Statement statement = connectedUtil.getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery(queryRead);
            while (resultSet.next()) {
                skillList.add(new Skill(resultSet.getInt("id"),
                        resultSet.getString("name")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Skill> findByName(String nameSkills) {
        List<Skill> skillList = new ArrayList<>();
        String queryFind = "SELECT * FROM skills WHERE name = ?";
        try (PreparedStatement preparedStatement = connectedUtil.getConnection().prepareStatement(queryFind)) {
            preparedStatement.setString(1, nameSkills);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                skillList.add(new Skill(resultSet.getInt("id"),
                        resultSet.getString("name")));
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return skillList;
    }

    @Override
    public void update(Skill skill) {
        if (skill != null) {
            String quwery = "UPDATE skills SET name = ? WHERE id = ?";
            try (PreparedStatement preparedStatement = connectedUtil.getConnection().prepareStatement(quwery)) {
                preparedStatement.setString(1, skill.getName());
                int flag = preparedStatement.executeUpdate();
                if (flag == 1) {
                    System.out.println("Skiil's name added to DB");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("error. Skill can not be NULL");
        }
    }

    @Override
    public void delete(Skill skill) {
        if (skill != null) {
            String quwery = "UPDATE skills SET name = ? WHERE id = ?";
            try (PreparedStatement preparedStatement = connectedUtil.getConnection().prepareStatement(quwery)) {
                preparedStatement.setString(1, skill.getName());
                int flag = preparedStatement.executeUpdate();
                if (flag == 1) {
                    System.out.println("Skiil's name added to DB");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("error. Skill can not be NULL");
        }
    }
}
