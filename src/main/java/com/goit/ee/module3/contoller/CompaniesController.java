package com.goit.ee.module3.contoller;

import com.goit.ee.module3.dao.CompaniesDAOImplH;
import com.goit.ee.module3.dto.Company;

import static com.goit.ee.module3.contoller.ConsoleUtils.getParam;
import static com.goit.ee.module3.contoller.ConsoleUtils.readParameter;

public class CompaniesController implements Executable {

    private Company createCompany() {
        Company company = new Company();
        company.setName(readParameter("name of company"));
        company.setAddress(readParameter("address of company"));
        return company;
    }

    @Override
    public void execute(Command command) {

        CompaniesDAOImplH companiesDAO = new CompaniesDAOImplH();

        switch (command) {
            case CREATE:
                companiesDAO.create(createCompany());
                break;
            case READ:
                System.out.println(companiesDAO.get(getParam("id of company")));
                break;
            case UPDATE:
                companiesDAO.update(createCompany(), getParam("id of company"));
                break;
            case DELETE:
                companiesDAO.delete(getParam("id of company"));
                break;
            case GET_ALL:
                companiesDAO.getAll().forEach(System.out::println);
                break;
            default:
                System.out.println("Not found command");
        }
    }
}

