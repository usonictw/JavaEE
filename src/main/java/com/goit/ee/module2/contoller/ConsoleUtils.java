package com.goit.ee.module2.contoller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by user on 06.12.2016.
 */
public class ConsoleUtils {

    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private void printMassege(){
        System.out.println("The Project added to DB successful");
        System.out.println("projects's name is NULL");
    }

    private String readProjectName() {
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
