package com.goit.ee.module2.dao;

import com.goit.ee.module2.dto.Developer;

import java.sql.SQLException;

/**
 * Created by Alex on 04.12.2016.
 */
public class main {
    public static void main(String[] args) {

    ConnectedUtil connectedUtil = new ConnectedUtil();
        try {
            connectedUtil.getConnection().createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
