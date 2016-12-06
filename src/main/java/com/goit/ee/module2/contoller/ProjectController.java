package com.goit.ee.module2.contoller;

import com.goit.ee.module2.dao.ProjectDAOImpl;
import com.goit.ee.module2.dto.Project;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProjectController implements Executable {

    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private ProjectDAOImpl projectDAO = new ProjectDAOImpl();

    @Override
    public void execute(Command command) {

        switch (command) {
            case CREATE:
                Project project = new Project();
                project.setName(getProjectName());
                project.setCost(getProjectCost());
                projectDAO.create(project);
            case READ:
                projectDAO.get(getProjectId());
            case UPDATE:
                projectDAO.update(new Project(getProjectId(), getProjectName(), getProjectCost()));
            case DELETE:
                projectDAO.delete(getProjectId());
        }
    }

    private String getProjectName() {
        String projectName = null;
        System.out.println("Input projects name");
        try {
            projectName = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return projectName;
    }

    private int getProjectCost() {
        String projCostStr = null;
        int projectCost = 0;
        System.out.println("Input projects cost");
        try {
            projCostStr = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (projCostStr != null) {
                projectCost = Integer.valueOf(projCostStr);
            }
        } catch (NumberFormatException | NullPointerException e) {
            System.out.println("input cost correctly");
        }
        return projectCost;
    }

    private int getProjectId() {
        String projIdStr = null;
        int projectId = 0;
        System.out.println("Input projects id");
        try {
            projIdStr = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (projIdStr != null) {
                projectId = Integer.valueOf(projIdStr);
            }
        } catch (NumberFormatException e) {
            System.out.println("input cost correctly");
        }
        return projectId;
    }
}


