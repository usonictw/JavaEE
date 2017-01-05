package com.goit.ee.module3;

import com.goit.ee.module3.menu.CreateMenuLevel1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleRunner {

    public void run() {

        System.out.println("Welcome to the console application to work with the database");

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String menuLevel_1;
            System.out.println("To get started with the application enter \"1\" to exit the application, enter \"0\"");
            menuLevel_1 = br.readLine();
            if (menuLevel_1.equals("0")) {
                System.exit(0);
            } else if (menuLevel_1.equals("1")) {
                CreateMenuLevel1 createMenuLevel1 = new CreateMenuLevel1();
                createMenuLevel1.menu1();
            } else {
                run();
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
    public static void main(String[] args) {
        ConsoleRunner consoleRunner = new ConsoleRunner();
        consoleRunner.run();
    }
}
