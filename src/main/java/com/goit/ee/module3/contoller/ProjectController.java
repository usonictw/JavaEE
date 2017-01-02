package com.goit.ee.module3.contoller;

import com.goit.ee.module3.dao.DevelopersDAOImplH;
import com.goit.ee.module3.dao.ProjectDAOImplH;
import com.goit.ee.module3.dto.Developer;
import com.goit.ee.module3.dto.Project;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.goit.ee.module3.contoller.ConsoleUtils.*;

public class ProjectController implements Executable {

    private ProjectDAOImplH projectDAO = new ProjectDAOImplH();

    private Project transientProject() {
        Project project = new Project();
        project.setName(readParameter("name of project"));
        project.setCost(getParam("cost"));
        project.setDevelopers(developers());
        return project;
    }

    private Set<Developer> developers() {

        long numberOfDevelopers;
        Set<Developer> developerList = new HashSet<>();
        DevelopersDAOImplH developersDAOImplH = new DevelopersDAOImplH();
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


