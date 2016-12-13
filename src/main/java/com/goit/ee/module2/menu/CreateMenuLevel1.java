package com.goit.ee.module2.menu;

/**
 * Created by PC on 10.12.2016.
 */
public class CreateMenuLevel1 {

    private String menu1Title1 = "Developer";
    private String menu1Title2 = "Skills";
    private String menu1Title3 = "Project";
    private String menu1Title4 = "Companies";
    private String menu1Title5 = "Customer";


    public static Menu1 menu1 = new Menu1();

    public void menu1() {
        String message = "You have selected a table";
                menu1.addEntry(new MenuEntry(menu1Title1) {
            @Override
            public void run() {
                System.out.println( message + " " + menu1Title1);
                new CreateMenuLevel2().menuLevel2();
            }
        });
        menu1.addEntry(new MenuEntry(menu1Title2) {
            @Override
            public void run() {
                System.out.println(message + " " + menu1Title2);
                new CreateMenuLevel2().menuLevel2();
            }
        });
        menu1.addEntry(new MenuEntry(menu1Title3) {
            @Override
            public void run() {
                System.out.println(message + " " + menu1Title3);
                new CreateMenuLevel2().menuLevel2();
            }
        });
        menu1.addEntry(new MenuEntry(menu1Title4) {
            @Override
            public void run() {
                System.out.println(message + " " + menu1Title4);
                new CreateMenuLevel2().menuLevel2();
            }
        });
        menu1.addEntry(new MenuEntry(menu1Title5) {
            @Override
            public void run() {
                System.out.println(message + " " + menu1Title5);
                new CreateMenuLevel2().menuLevel2();
            }
        });
        menu1.choiceItem();
    }

    public static void main(String[] args) {

        CreateMenuLevel1 createMenuLevel1 = new CreateMenuLevel1();
        createMenuLevel1.menu1();
    }
}
