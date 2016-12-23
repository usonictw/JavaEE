package com.goit.ee.module2.contoller;

import com.goit.ee.module2.dao.ProjectDAOImplH;
import com.goit.ee.module2.dto.Project;
import static com.goit.ee.module2.contoller.ConsoleUtils.*;

public class ProjectController implements Executable {

    private ProjectDAOImplH projectDAO = new ProjectDAOImplH();

    @Override
    public void execute(Command command) {
        switch (command) {
            case CREATE:
                Project project = new Project();
                project.setName(readParameter("name"));
                project.setCost(getParam("cost"));
                projectDAO.create(project);
                break;
            case READ:
                projectDAO.get(getParam("id"));
                break;
            case UPDATE:
                projectDAO.update(new Project(getParam("id"),
                        readParameter("name"),
                        getParam("cost")));
                projectDAO.getAll().forEach(System.out::println);
                break;
            case DELETE:
                int byId = getParam("id");
                projectDAO.delete(byId);
                    projectDAO.getAll().forEach(System.out::println);
                break;
            case GET_ALL:
                projectDAO.getAll().forEach(System.out::println);
                break;
            default:
                System.out.println("Not found command");
        }
    }
}


