package com.goit.ee.module3.contoller;

import com.goit.ee.module3.dao.CustomerDAOImplH;
import com.goit.ee.module3.dto.Customer;

import static com.goit.ee.module3.contoller.ConsoleUtils.*;

public class CustomerController implements Executable {

    @Override
    public void execute(Command command) {

        CustomerDAOImplH customerDAO = new CustomerDAOImplH();

        switch (command) {
            case CREATE:
                Customer customer = new Customer();
                customer.setName(readParameter("name"));
                customer.setAddress(readParameter("address"));
                customerDAO.create(customer);
                break;
            case READ:
                customerDAO.get(getParam("id"));
                break;
            case UPDATE:
                customerDAO.update(new Customer(getParam("id"),
                        readParameter("name"),
                        readParameter("address")), getParam("id"));

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
