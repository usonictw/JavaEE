package com.goit.ee.module3.menu;

import com.goit.ee.module3.contoller.*;

public class CreateMenuLevel2 {

    Menu2 menu2 = new Menu2();

    protected void menuLevel2() {

        menu2.addEntry(new MenuEntry("Create") {
            @Override
            public void run() {
                switch (CreateMenuLevel1.menu1.menuEntryList.get(Menu1.choice - 1).getTitle()) {
                    case "Developer":
                        DeveloperController developerController = new DeveloperController();
                        developerController.execute(Command.CREATE);
                        break;
                    case "Skills":
                        SkillController skillController = new SkillController();
                        skillController.execute(Command.CREATE);
                        break;
                    case "Project":
                        ProjectController projectController = new ProjectController();
                        projectController.execute(Command.CREATE);
                        break;
                    case "Companies":
                        CompaniesController companiesController = new CompaniesController();
                        companiesController.execute(Command.CREATE);
                        break;
                    case "Customer":
                        CustomerController customerController = new CustomerController();
                        customerController.execute(Command.CREATE);
                        break;
                    default:
                        System.out.println("Item's menu not found");
                }
            }
        });
        menu2.addEntry(new MenuEntry("Read") {
            @Override
            public void run() {
                switch (CreateMenuLevel1.menu1.menuEntryList.get(Menu1.choice - 1).getTitle()) {
                    case "Developer":
                        DeveloperController developerController = new DeveloperController();
                        developerController.execute(Command.READ);
                        break;
                    case "Skills":
                        SkillController skillController = new SkillController();
                        skillController.execute(Command.READ);
                        break;
                    case "Project":
                        ProjectController projectController = new ProjectController();
                        projectController.execute(Command.READ);
                        break;
                    case "Companies":
                        CompaniesController companiesController = new CompaniesController();
                        companiesController.execute(Command.READ);
                        break;
                    case "Customer":
                        CustomerController customerController = new CustomerController();
                        customerController.execute(Command.READ);
                        break;
                    default:
                        System.out.println("Item's menu not found");
                }
            }
        });
        menu2.addEntry(new MenuEntry("Update") {
            @Override
            public void run() {
                switch (CreateMenuLevel1.menu1.menuEntryList.get(Menu1.choice - 1).getTitle()) {
                    case "Developer":
                        DeveloperController developerController = new DeveloperController();
                        developerController.execute(Command.UPDATE);
                        break;
                    case "Skills":
                        SkillController skillController = new SkillController();
                        skillController.execute(Command.UPDATE);
                        break;
                    case "Project":
                        ProjectController projectController = new ProjectController();
                        projectController.execute(Command.UPDATE);
                        break;
                    case "Companies":
                        CompaniesController companiesController = new CompaniesController();
                        companiesController.execute(Command.UPDATE);
                        break;
                    case "Customer":
                        CustomerController customerController = new CustomerController();
                        customerController.execute(Command.UPDATE);
                        break;
                    default:
                        System.out.println("Item's menu not found");
                }
            }
        });
        menu2.addEntry(new MenuEntry("Delete") {
            @Override
            public void run() {
                switch (CreateMenuLevel1.menu1.menuEntryList.get(Menu1.choice - 1).getTitle()) {
                    case "Developer":
                        DeveloperController developerController = new DeveloperController();
                        developerController.execute(Command.DELETE);
                        break;
                    case "Skills":
                        SkillController skillController = new SkillController();
                        skillController.execute(Command.DELETE);
                        break;
                    case "Project":
                        ProjectController projectController = new ProjectController();
                        projectController.execute(Command.DELETE);
                        break;
                    case "Companies":
                        CompaniesController companiesController = new CompaniesController();
                        companiesController.execute(Command.DELETE);
                        break;
                    case "Customer":
                        CustomerController customerController = new CustomerController();
                        customerController.execute(Command.DELETE);
                        break;
                    default:
                        System.out.println("Item's menu not found");
                }
            }
        });
        menu2.addEntry(new MenuEntry("Get All") {
            @Override
            public void run() {

                switch (CreateMenuLevel1.menu1.menuEntryList.get(Menu1.choice - 1).getTitle()) {
                    case "Developer":
                        DeveloperController developerController = new DeveloperController();
                        developerController.execute(Command.GET_ALL);
                        break;
                    case "Skills":
                        SkillController skillController = new SkillController();
                        skillController.execute(Command.GET_ALL);
                        break;
                    case "Project":
                        ProjectController projectController = new ProjectController();
                        projectController.execute(Command.GET_ALL);
                        break;
                    case "Companies":
                        CompaniesController companiesController = new CompaniesController();
                        companiesController.execute(Command.GET_ALL);
                        break;
                    case "Customer":
                        CustomerController customerController = new CustomerController();
                        customerController.execute(Command.GET_ALL);
                        break;
                    default:
                        System.out.println("Item's menu not found");
                }
            }
        });
        menu2.choiceItem();
    }

}
