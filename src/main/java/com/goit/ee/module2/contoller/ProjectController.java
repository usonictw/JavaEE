package com.goit.ee.module2.contoller;

import com.goit.ee.module2.dao.ProjectDAOImpl;
import com.goit.ee.module2.dto.Project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by user on 05.12.2016.
 */
public class ProjectController implements Executable {

    private String dataInput() {
        String dataInput = null;
        int countLine = 1;
        while (countLine > 0) {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
                dataInput = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            countLine--;
        }

        return dataInput;
    }

    @Override
    public void execute(Command command) {
        ProjectDAOImpl projectDAO = new ProjectDAOImpl();
        if (command.equals(Command.CREATE)) {
            System.out.println("Input projects name");
            String projectName = dataInput();
            System.out.println("Input projects cost");
            String projCostStr = dataInput();
            int projectCost = 0;
            try {
                projectCost = Integer.valueOf(projCostStr);
            } catch (NumberFormatException e) {
                System.out.println("input cost correctly");
            }
            projectDAO.create(new Project(1, projectName, projectCost));
        }
    }


    public static void main(String[] args) {

        ProjectController projectController = new ProjectController();

        projectController.execute(Command.CREATE);
    }
}


