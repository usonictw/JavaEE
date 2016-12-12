package com.goit.ee.module2.contoller;

import com.goit.ee.module2.dao.ProjectDAOImpl;
import com.goit.ee.module2.dto.Project;

import static com.goit.ee.module2.contoller.ConsoleUtils.*;
import static com.goit.ee.module2.dao.ProjectDAOImpl.*;

public class ProjectController implements Executable {

    private ProjectDAOImpl projectDAO = new ProjectDAOImpl();

    @Override
    public void execute(Command command) {
        switch (command) {
            case CREATE:
                Project project = new Project();
                project.setName(readParameter(name));
                project.setCost(getParam(cost));
                if (projectDAO.create(project)) {
                    System.out.println(readParameter(name) + " is created");
                } else {
                    System.out.println("Error." + readParameter(name) + "is not created");
                }
                break;
            case READ:
                projectDAO.get(getParam(id));
                break;
            case UPDATE:
                projectDAO.update(new Project(getParam(id),
                        readParameter(id),
                        getParam(id)));
                projectDAO.getAll().forEach(System.out::println);
                break;
            case DELETE:
                if (projectDAO.delete(getParam(id))){
                    System.out.println(projectDAO.get(getParam(id)) + "is deleted");
                }else{
                    System.out.println("Object not found");
                }

                projectDAO.getAll().forEach(System.out::println);
            case GET_ALL:
                projectDAO.getAll().forEach(System.out::println);
                break;
            default:
                System.out.println("Not found command");
        }
    }
}


