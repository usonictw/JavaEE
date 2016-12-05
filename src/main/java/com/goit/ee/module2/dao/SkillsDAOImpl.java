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

    public List<Skill> getAll() {
        List<Skill> skillList = new ArrayList<>();
        String queryRead = "SELECT * FROM Skills";
        try (Statement statement = connectedUtil.getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery(queryRead);
            while (resultSet.next()) {
                skillList.add(new Skill(resultSet.getInt("id"),
                        resultSet.getString("name")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return skillList;
    }

    @Override
    public boolean create(Skill pr) {
        boolean flag = false;
        if (pr != null) {
            String query = "INSERT INTO Skills(name) VALUES (?)";
            try (PreparedStatement preparedStatement = connectedUtil.getConnection().prepareStatement(query)) {
                preparedStatement.setString(1, pr.getName());
                int count = preparedStatement.executeUpdate();
                if (count == 1) {
                    System.out.println("The Skill added to DB successful");
                    getAll().forEach(System.out::println);
                    flag = true;
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            return flag;
        } else {
            System.out.println("Skills's name is NULL");
            return flag;
        }
    }

    @Override
    public boolean get(long id) {
        boolean flag = false;
        if (id != 0) {
            String query = "SELECT * FROM Skills WHERE id = ?";
            try (PreparedStatement preparedStatement = connectedUtil.getConnection().prepareStatement(query)) {
                preparedStatement.setLong(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    System.out.println(new Skill(resultSet.getInt("id"),
                            resultSet.getString("name")));
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
            String query = "DELETE FROM Skills WHERE id = ?";
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
    public boolean update(Skill pr) {
        boolean flag = false;
        if (pr != null) {
            String query = "UPDATE Skills SET name = ? WHERE id = ?";
            try (PreparedStatement preparedStatement = connectedUtil.getConnection().prepareStatement(query)) {
                preparedStatement.setString(1, pr.getName());
                preparedStatement.setLong(2, pr.getId());
                int count = preparedStatement.executeUpdate();
                if (count == 1) {
                    System.out.println("The Skill added to DB successful");
                    getAll().forEach(System.out::println);
                    flag = true;
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            return flag;
        } else {
            System.out.println("the Skills can not be NULL");
            return flag;
        }
    }

    @Override
    public List<Skill> findByName(String nameSkill) {
        List<Skill> skillList = new ArrayList<>();
        if (nameSkill != null) {
            String queryFind = "SELECT * FROM Skills WHERE name = ?";
            try (PreparedStatement preparedStatement = connectedUtil.getConnection().prepareStatement(queryFind)) {
                preparedStatement.setString(1, nameSkill);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (!resultSet.next()) {
                    System.out.println("Skill's name not found");
                }
                while (resultSet.next()) {
                    skillList.add(new Skill(resultSet.getInt("id"),
                            resultSet.getString("name")));
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            return skillList;
        } else {
            System.out.println("Skill name can not NULL");
            return skillList;
        }
    }
}
