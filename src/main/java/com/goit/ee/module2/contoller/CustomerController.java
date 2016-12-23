package com.goit.ee.module2.contoller;

import com.goit.ee.module2.dao.CustomerDAOImplH;
import com.goit.ee.module2.dto.Customer;
import static com.goit.ee.module2.contoller.ConsoleUtils.*;

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
                        readParameter("address")));
                customerDAO.getAll().forEach(System.out::println);
                break;
            case DELETE:
                int byId = getParam("id");
                customerDAO.delete(byId);
                customerDAO.getAll().forEach(System.out::println);
                break;
            case GET_ALL:
                customerDAO.getAll().forEach(System.out::println);
                break;
            default:
                System.out.println("Not found command");
        }
    }
}
