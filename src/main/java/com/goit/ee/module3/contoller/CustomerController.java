package com.goit.ee.module3.contoller;

import com.goit.ee.module3.dao.CustomerDAOImplH;
import com.goit.ee.module3.dao.ProjectDAOImplH;
import com.goit.ee.module3.dto.Customer;
import com.goit.ee.module3.dto.Project;

import java.util.HashSet;
import java.util.Set;

import static com.goit.ee.module3.contoller.ConsoleUtils.*;

public class CustomerController implements Executable {

    private Customer createCustomer(){
        Customer customer = new Customer();
        customer.setName(readParameter("name of customer"));
        customer.setAddress(readParameter("address of customer"));
        customer.setProjects(customer());
        return customer;
    }

    private Set<Project> customer(){
        Set<Project> projectSet = new HashSet<>();
        long numberProject;
        ProjectDAOImplH projectDAOImplH = new ProjectDAOImplH();
        projectDAOImplH.getAll().forEach(System.out::println);
        numberProject = getParam("number of project");
        for (int i = 0; i < numberProject; i++){
            projectSet.add(projectDAOImplH.get(getParam("id of project")));
        }
        return projectSet;
    }

    @Override
    public void execute(Command command) {

        CustomerDAOImplH customerDAO = new CustomerDAOImplH();

        switch (command) {
            case CREATE:
                customerDAO.create(createCustomer());
                break;
            case READ:
                customerDAO.get(getParam("id of cusromer"));
                break;
            case UPDATE:
                customerDAO.update(createCustomer(), getParam("id of customer"));
                break;
            case DELETE:
                customerDAO.delete(getParam("id of customer"));
                break;
            case GET_ALL:
                customerDAO.getAll().forEach(System.out::println);
                break;
            default:
                System.out.println("Not found command");
        }
    }
}
