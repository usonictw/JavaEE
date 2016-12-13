package com.goit.ee.module2.contoller;

import com.goit.ee.module2.dao.CustomerDAOImpl;
import com.goit.ee.module2.dto.Customer;

import static com.goit.ee.module2.contoller.ConsoleUtils.*;
import static com.goit.ee.module2.dao.CustomerDAOImpl.*;

public class CustomerController implements Executable {

    @Override
    public void execute(Command command) {

        CustomerDAOImpl customerDAO = new CustomerDAOImpl();

        switch (command) {
            case CREATE:
                Customer customer = new Customer();
                customer.setName(readParameter(columnName));
                customer.setAddress(readParameter(columnAddress));
                if (customerDAO.create(customer)) {
                    System.out.println(customer.getName() + " is created");
                } else {
                    System.out.println("Error." + customer.getName() + "is not created");
                }
                break;
            case READ:
                customerDAO.get(getParam(columnId));
                break;
            case UPDATE:
                customerDAO.update(new Customer(getParam(columnId),
                        readParameter(columnName),
                        readParameter(columnAddress)));
                customerDAO.getAll().forEach(System.out::println);
                break;
            case DELETE:
                int byId = getParam(columnId);
                if (customerDAO.delete(byId)) {
                    customerDAO.getAll().forEach(System.out::println);
                } else {
                    System.out.println("Object is not found");
                }
                break;
            case GET_ALL:
                customerDAO.getAll().forEach(System.out::println);
                break;
            default:
                System.out.println("Not found command");
        }
    }
}
