package com.goit.ee.module2.dao;

/**
 * Created by PC on 01.12.2016.
 */
public class SkillsDAOImpl implements SkillsDAO {


    static {
        String driver = "org.postgresql.Driver";
        try {
            Class.forName(driver);
            System.out.println("the driver successfully connected");
        } catch (ClassNotFoundException e) {
            System.out.println("error: ");
            e.printStackTrace();
        }
    }

    public void create() {


    }

    public void findByName(String nameSkills) {

    }
}
