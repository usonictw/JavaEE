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
    private static final String id = "id";
    private static final String name = "name";

    private String selectAll = "SELECT * FROM Skills";
    private String insert = "INSERT INTO Skills(name, cost) VALUES (?,?)";
    private String selectById = "SELECT * FROM Skills WHERE id = ?";
    private String deleteByID = "DELETE FROM Skills WHERE id = ?";
    private String update = "UPDATE Skills SET name = ?, cost = ? WHERE id = ?";
    private String selectByName = "SELECT * FROM Skills WHERE name = ?";

    public List<Skill> getAll() {
        List<Skill> skillList = new ArrayList<>();
        try (Statement statement = connectedUtil.getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery(selectAll);
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

            try (PreparedStatement preparedStatement = connectedUtil.getConnection().prepareStatement(insert)) {
                preparedStatement.setString(1, pr.getName());
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
                    System.out.println(new Skill(resultSet.getInt("id"),
                            resultSet.getString("name")));
                    flag = true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return flag;
    }

    @Override
    public boolean delete(long id) {
        boolean flag = false;
        if (id != 0) {
            try (PreparedStatement preparedStatement = connectedUtil.getConnection().prepareStatement(deleteByID)) {
                preparedStatement.setLong(1, id);
                int count = preparedStatement.executeUpdate();
                if (count == 1) {
                    getAll().forEach(System.out::println);
                    flag = true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return flag;
    }

    @Override
    public boolean update(Skill pr) {
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
    public List<Skill> findByName(String nameSkill) {
        List<Skill> skillList = new ArrayList<>();
        if (nameSkill != null) {
            try (PreparedStatement preparedStatement = connectedUtil.getConnection().prepareStatement(selectByName)) {
                preparedStatement.setString(1, nameSkill);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    skillList.add(new Skill(resultSet.getInt("id"),
                            resultSet.getString("name")));
                }
            } catch (SQLException e1) {
                System.out.println("query SQL error");
            }
        }
        return skillList;
    }
}
