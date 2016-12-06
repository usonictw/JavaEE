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
                projectDAO.create(project);
                break;
            case READ:
                projectDAO.get(getParam(id));
                break;
            case UPDATE:
                projectDAO.update(new Project(getParam(id),
                        readParameter(id),
                        getParam(id)));
                break;
            case DELETE:
                projectDAO.delete(getParam(id));
                break;
        }
    }
}


