package com.goit.ee.module2.contoller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by user on 06.12.2016.
 */
public class ConsoleUtils {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void printMessage() {
        String createObject;
        String getObject;
        String updateObject;
        String deleteObject;
        System.out.println("projects's name is NULL");
    }

    public static String readParameter(String parameter) {

        System.out.println("Input " + parameter);
        try {
            parameter = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return parameter;
    }

    public static int getParam(String parameter) {
        int paramInt = 0;
        System.out.println("Input " + parameter);
        try {
            parameter = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (parameter != null) {
                paramInt = Integer.valueOf(parameter);
            }
        } catch (NumberFormatException | NullPointerException e) {
            System.out.println("input parameter correctly");
        }
        return paramInt;
    }

}
