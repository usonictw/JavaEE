package com.goit.ee.module3.contoller;

import com.goit.ee.module3.dao.DevelopersDAOImplH;
import com.goit.ee.module3.dao.ProjectDAOImplH;
import com.goit.ee.module3.dto.Developer;
import com.goit.ee.module3.dto.Project;

import java.util.ArrayList;
import java.util.List;

import static com.goit.ee.module3.contoller.ConsoleUtils.*;

public class ProjectController implements Executable {

    private ProjectDAOImplH projectDAO = new ProjectDAOImplH();

    private Project transientProject() {
        Project project = new Project();
        project.setName(readParameter("name of project"));
        project.setCost(getParam("cost"));
        project.addDevelopers(developers());

        return project;
    }

    private List<Developer> developers() {
        List<Developer> developerList = new ArrayList<>();
        DevelopersDAOImplH developersDAOImplH = new DevelopersDAOImplH();
        long numberOfDevelopers;
        developersDAOImplH.getAll().forEach(System.out::println);
        numberOfDevelopers = getParam("number of developers");
        for (int i = 0; i < numberOfDevelopers; i++) {
            developerList.add(developersDAOImplH.get(getParam("id of developer")));
        }
        return developerList;
    }

    @Override
    public void execute(Command command) {
        switch (command) {
            case CREATE:
                projectDAO.create(transientProject());
                break;
            case READ:
                projectDAO.get(getParam("id of project"));
                break;
            case UPDATE:
                projectDAO.update(transientProject(), getParam("id of project"));
                break;
            case DELETE:
                projectDAO.delete(getParam("id of project"));
                break;
            case GET_ALL:
                projectDAO.getAll().forEach(System.out::println);
                break;
            default:
                System.out.println("Not found command");
        }
    }
}


