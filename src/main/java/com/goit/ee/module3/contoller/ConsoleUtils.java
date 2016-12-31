package com.goit.ee.module3.contoller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class  ConsoleUtils {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static String readParameter(String parameter) {

        System.out.println("Input " + parameter);
        try {
            parameter = br.readLine();
        } catch (IOException e) {
            System.out.println("Input from the console error");
        }
        return parameter;
    }

    public static long getParam(String parameter) {
        int paramInt = 0;
        System.out.println("Input " + parameter);
        try {
            parameter = br.readLine();
        } catch (IOException e) {
            System.out.println("Input from the console error");
        }
        try {
            if (parameter != null) {
                paramInt = Integer.valueOf(parameter);
            }
        } catch (NumberFormatException | NullPointerException e) {
            System.out.println("Input parameter correctly");
        }
        return paramInt;
    }
}
