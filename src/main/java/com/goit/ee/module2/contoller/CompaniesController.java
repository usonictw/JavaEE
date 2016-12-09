package com.goit.ee.module2.contoller;

import com.goit.ee.module2.dao.CompaniesDAOImpl;
import com.goit.ee.module2.dto.Company;
import com.goit.ee.module2.dto.Company;

import static com.goit.ee.module2.contoller.ConsoleUtils.getParam;
import static com.goit.ee.module2.contoller.ConsoleUtils.readParameter;

public class CompaniesController implements Executable {


    @Override
    public void execute(Command command) {

        CompaniesDAOImpl companiesDAO = new CompaniesDAOImpl();

        switch (command) {
            case CREATE:
                Company company = new Company();
                company.setName(readParameter("name"));
                company.setAddress(readParameter("address"));
                if (companiesDAO.create(company)) {
                    System.out.println(readParameter("name") + " is created");
                } else {
                    System.out.println("Error." + readParameter("name") + "is not created");
                }
                break;
            case READ:
                companiesDAO.get(getParam("id"));
                break;
            case UPDATE:
                companiesDAO.update(new Company(getParam("id"),
                        readParameter("name"),
                        readParameter("address")));
                break;
            case DELETE:
                companiesDAO.delete(getParam("id"));
                break;
            case GET_ALL:
                companiesDAO.showAllData();
                break;
            default:
                System.out.println("Not found command");
        }
    }

    public static void main(String[] args) {

        CompaniesController companiesController = new CompaniesController();

        companiesController.execute(Command.DELETE);
    }
}

