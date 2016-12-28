package com.goit.ee.module2.contoller;

import com.goit.ee.module2.dao.DevelopersDAOImplH;
import com.goit.ee.module2.dao.SkillDAOImplH;
import com.goit.ee.module2.dto.Developer;
import com.goit.ee.module2.dto.Skill;

import java.util.List;

import static com.goit.ee.module2.contoller.ConsoleUtils.getParam;
import static com.goit.ee.module2.contoller.ConsoleUtils.readParameter;

public class DeveloperController implements Executable {

    DevelopersDAOImplH developersDAOImplH = new DevelopersDAOImplH();

    private Developer createDeveloper() {
        Developer developer = new Developer();
        developer.setFirstName(readParameter("First name"));
        developer.setLastName(readParameter("Last Name"));
        developer.setAge((int) getParam("Age"));
        developer.setSalary((int) getParam("Salary"));
        developer.addSkill(skill());
        return developer;
    }

    private Skill skill() {
        SkillDAOImplH skillDAOImplH = new SkillDAOImplH();
        System.out.println(skillDAOImplH.getAll());
        return skillDAOImplH.get(getParam("id"));
    }

    @Override
    public void execute(Command command) {
        switch (command) {
            case CREATE:
                developersDAOImplH.create(createDeveloper());
                break;
            case READ:
                developersDAOImplH.get(getParam("id"));
                break;
            case UPDATE:
                developersDAOImplH.update(createDeveloper(), getParam("id"));
                break;
            case DELETE:
                developersDAOImplH.delete(getParam("id"));
                break;
            case GET_ALL:
                developersDAOImplH.getAll();
                break;
            default:
                System.out.println("Not found command");
        }
    }

}
