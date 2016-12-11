package com.goit.ee.module2.menu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by PC on 10.12.2016.
 */
public class Menu {

    public List<MenuEntry> menuEntryList = new ArrayList<>();
    private boolean isExit = false;

    public Menu() {

        menuEntryList.add(new MenuEntry("Exit") {
            @Override
            public void run() {
                isExit = true;
            }
        });
    }

    public MenuEntry run() {
        MenuEntry entry = null;
        while (!isExit) {
            printMenu();
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try {
                String line = reader.readLine();
                int choice = Integer.parseInt(line);
                entry = menuEntryList.get(choice - 1);
                entry.run();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return entry;
    }

    public Menu addEntry(MenuEntry entry) {
        int index = menuEntryList.size() - 1;
        menuEntryList.add(index, entry);
        return this;
    }

    private void printMenu() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("\nMenu:\n");
        for (int i = 0; i < menuEntryList.size(); i++) {
            MenuEntry entry = menuEntryList.get(i);
            String entryFormatted = String.format("%s. %s\n",(i + 1), entry.getTitle());
            buffer.append(entryFormatted);
        }
        System.out.print(buffer.toString());
    }
}
