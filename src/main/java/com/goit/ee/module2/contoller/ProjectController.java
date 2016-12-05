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

    private Project project = new Project();

    @Override
    public void execute(Command command) {
        ProjectDAOImpl projectDAO = new ProjectDAOImpl();
        if (command.equals(Command.CREATE)) {
            int countLine = 1;
            while (countLine > 0) {
                try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
                    String input = br.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                countLine--;


            }
            //projectDAO.create()
        }
    }
}
