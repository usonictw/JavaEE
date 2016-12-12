package com.goit.ee.module2.menu;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by PC on 10.12.2016.
 */
public class Menu1 {

    public List<MenuEntry> menuEntryList = new ArrayList<>();
    private boolean isExit = false;
    public static int choice;

    public Menu1() {

        menuEntryList.add(new MenuEntry("Exit") {
            @Override
            public void run() {
                isExit = true;
            }
        });
    }

    public void choiceItem() {
        MenuEntry entry = null;
        while (!isExit) {
            printMenu();
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try {
                String line = reader.readLine();
                try {
                    choice = Integer.parseInt(line);
                    entry = menuEntryList.get(choice - 1);
                    entry.run();
                }catch (NumberFormatException nfe){
                    System.out.println("Error. Enter of the number");
                    choiceItem();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public Menu1 addEntry(MenuEntry entry) {
        int index = menuEntryList.size() - 1;
        menuEntryList.add(index, entry);
        return this;
    }

    private void printMenu() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("\nMenu 1: Enter of the number from \"1\" to " + menuEntryList.size() + "\n");
        for (int i = 0; i < menuEntryList.size(); i++) {
            MenuEntry entry = menuEntryList.get(i);
            String entryFormatted = String.format("%s. %s\n",(i + 1), entry.getTitle());
            buffer.append(entryFormatted);
        }
        System.out.print(buffer.toString());
    }
}
