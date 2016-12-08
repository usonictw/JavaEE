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
    public static final String columnId = "id";
    public static final String columnName = "name";

    private String selectAll = "SELECT * FROM skills";
    private String insert = "INSERT INTO skills(name) VALUES (?)";
    private String selectById = "SELECT * FROM skills WHERE id = ?";
    private String deleteById = "DELETE FROM skills WHERE id = ?";
    private String update = "UPDATE Skills SET name = ? WHERE id = ?";
    private String selectByName = "SELECT * FROM skills WHERE name = ?";

    public List<Skill> getAll() {
        List<Skill> skillList = new ArrayList<>();
        try (Statement statement = connectedUtil.getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery(selectAll);
            while (resultSet.next()) {
                skillList.add(new Skill(resultSet.getInt(columnId),
                        resultSet.getString(columnName)));
            }
        } catch (SQLException e) {
            System.out.println("query SQL error");
        }
        return skillList;
    }

    @Override
    public boolean create(Skill skill) {
        boolean flag = false;
        if (skill != null) {
            try (PreparedStatement preparedStatement = connectedUtil.getConnection().prepareStatement(insert)) {
                preparedStatement.setString(1, skill.getName());
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
                    System.out.println(new Skill(resultSet.getInt(columnId),
                            resultSet.getString(columnName)));
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
            try (PreparedStatement preparedStatement = connectedUtil.getConnection().prepareStatement(deleteById)) {
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
                    skillList.add(new Skill(resultSet.getInt(columnId),
                            resultSet.getString(columnName)));
                }
            } catch (SQLException e1) {
                System.out.println("query SQL error");
            }
        }
        return skillList;
    }

    public static void main(String[] args) {

        Skill skill = new Skill();

        SkillsDAOImpl skillsDAO = new SkillsDAOImpl();

        skillsDAO.getAll().forEach(System.out::println);
        System.out.println();
        skillsDAO.delete(14);
    }
}

