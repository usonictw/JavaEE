package com.goit.ee.module2.dao;

import com.goit.ee.module2.dto.Developer;

/**
 * Created by Alex on 04.12.2016.
 */
public class main {
    public static void main(String[] args) {
        DeveloperDAOImpl developersDAO = new DeveloperDAOImpl();
        developersDAO.showAllData();
        developersDAO.findByNameAndLastName("Gregg", "Deak");
        developersDAO.findByName("Gregg");
        developersDAO.create(new Developer(44444,55,"Alex","Ramos",4444));
        developersDAO.delete(23);
    }
}
