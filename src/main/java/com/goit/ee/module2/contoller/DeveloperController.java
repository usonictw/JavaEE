package com.goit.ee.module2.contoller;

import com.goit.ee.module2.dao.DeveloperDAOImpl;
import com.goit.ee.module2.dto.Developer;

import static com.goit.ee.module2.contoller.ConsoleUtils.getParam;
import static com.goit.ee.module2.contoller.ConsoleUtils.readParameter;

/**
 * Created by PC on 09.12.2016.
 */
public class DeveloperController implements Executable {

    @Override
    public void execute(Command command) {
        DeveloperDAOImpl companiesDAO = new DeveloperDAOImpl();

        switch (command) {
            case CREATE:
                Developer developer = new Developer();
                developer.setFirstName(readParameter("first_name"));
                developer.setLastName(readParameter("last_name"));
                developer.setAge(getParam("age"));
                developer.setSalary(getParam("salary"));
                if (companiesDAO.create(developer)) {
                    System.out.println(readParameter("name") + " is created");
                } else {
                    System.out.println("Error." + readParameter("name") + "is not created");
                }
                break;
            case READ:
                companiesDAO.get(getParam("id"));
                break;
            case UPDATE:
                companiesDAO.update(new Developer(getParam("id"),
                        getParam("age"),
                        readParameter("first_name"),
                        readParameter("last_name"),
                        getParam("salary")));
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
}
