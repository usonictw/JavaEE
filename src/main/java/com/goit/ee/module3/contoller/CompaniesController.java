package com.goit.ee.module3.contoller;

import com.goit.ee.module3.dao.CompaniesDAOImplH;
import com.goit.ee.module3.dto.Company;

import static com.goit.ee.module3.contoller.ConsoleUtils.getParam;
import static com.goit.ee.module3.contoller.ConsoleUtils.readParameter;

public class CompaniesController implements Executable {


    @Override
    public void execute(Command command) {

        CompaniesDAOImplH companiesDAO = new CompaniesDAOImplH();

        switch (command) {
            case CREATE:
                Company company = new Company();
                company.setName(readParameter("name"));
                company.setAddress(readParameter("address"));
                companiesDAO.create(company);
                break;
            case READ:
                companiesDAO.get(getParam("id"));
                break;
            case UPDATE:
                companiesDAO.update(new Company(getParam("id"),
                        readParameter("name"),
                        readParameter("address")), getParam("id"));
                break;
            case DELETE:
                companiesDAO.delete(getParam("id"));
                break;
            case GET_ALL:
                companiesDAO.getAll();
                break;
            default:
                System.out.println("Not found command");
        }
    }
}

