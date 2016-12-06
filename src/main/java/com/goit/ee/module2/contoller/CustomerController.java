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
                customerDAO.create(customer);
                break;
            case READ:
                customerDAO.get(getParam(columnId));
                break;
            case UPDATE:
                customerDAO.update(new Customer(getParam(columnId),
                        readParameter(columnName),
                        readParameter(columnAddress)));
                break;
            case DELETE:
                customerDAO.delete(getParam(columnId));
                break;
        }
    }
}
