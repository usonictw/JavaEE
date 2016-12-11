package com.goit.ee.module2.menu;

import com.goit.ee.module2.contoller.Command;
import com.goit.ee.module2.contoller.DeveloperController;
import com.goit.ee.module2.dto.Developer;

/**
 * Created by PC on 10.12.2016.
 */
public class CreateMenuLevel2 {

    public  static Menu menu2 = new Menu();

    protected void menuLevel2() {

               menu2.addEntry(new MenuEntry("Create") {
            @Override
            public void run() {
                System.out.println("create");
            }
        });
        menu2.addEntry(new MenuEntry("Read") {
            @Override
            public void run() {
                System.out.println("test2 run");
            }
        });
        menu2.addEntry(new MenuEntry("Update") {
            @Override
            public void run() {
                System.out.println("test1 run");
            }
        });
        menu2.addEntry(new MenuEntry("Delete") {
            @Override
            public void run() {
                System.out.println("test1 run");
            }
        });
        menu2.addEntry(new MenuEntry("Get All") {
            @Override
            public void run() {

                if (CreateMenuLevel1.menu1.run().equals("Developer")) {
                    DeveloperController developerController = new DeveloperController();
                    developerController.execute(Command.GET_ALL);
                }
            }
        });
        menu2.run();
    }

}
