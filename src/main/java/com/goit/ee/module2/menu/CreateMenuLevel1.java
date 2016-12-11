package com.goit.ee.module2.menu;

import com.goit.ee.module2.dto.Developer;

/**
 * Created by PC on 10.12.2016.
 */
public class CreateMenuLevel1 {


    public static Menu menu1 = new Menu();

    public void menu1() {
        menu1.addEntry(new MenuEntry("Developer") {
            @Override
            public void run() {
                new CreateMenuLevel2().menuLevel2();
            }
        });
        menu1.addEntry(new MenuEntry("Skills") {
            @Override
            public void run() {
                new CreateMenuLevel2().menuLevel2();
            }
        });
        menu1.addEntry(new MenuEntry("Project") {
            @Override
            public void run() {
                new CreateMenuLevel2().menuLevel2();
            }
        });
        menu1.addEntry(new MenuEntry("Companies") {
            @Override
            public void run() {
                new CreateMenuLevel2().menuLevel2();
            }
        });
        menu1.addEntry(new MenuEntry("Customer") {
            @Override
            public void run() {
                new CreateMenuLevel2().menuLevel2();
            }
        });
        menu1.run();
    }

    public static void main(String[] args) {

        CreateMenuLevel1 createMenuLevel1 = new CreateMenuLevel1();
        createMenuLevel1.menu1();
    }
}
