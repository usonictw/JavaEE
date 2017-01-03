package com.goit.ee.module3.contoller;

import com.goit.ee.module3.dao.DevelopersDAOImplH;
import com.goit.ee.module3.dao.SkillDAOImplH;
import com.goit.ee.module3.dto.Developer;
import com.goit.ee.module3.dto.Skill;

import javax.persistence.SequenceGenerator;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.goit.ee.module3.contoller.ConsoleUtils.getParam;
import static com.goit.ee.module3.contoller.ConsoleUtils.readParameter;

public class DeveloperController implements Executable {

    DevelopersDAOImplH developersDAOImplH = new DevelopersDAOImplH();

    private Developer createDeveloper() {
        Developer developer = new Developer();
        developer.setFirstName(readParameter("First name"));
        developer.setLastName(readParameter("Last Name"));
        developer.setAge((int) getParam("Age"));
        developer.setSalary((int) getParam("Salary"));
        //developer.setSkills(skill());
        return developer;
    }

    /*private Set<Skill> skill() {
        Set<Skill> skillList = new HashSet<>();
        long numbersSkills;
        SkillDAOImplH skillDAOImplH = new SkillDAOImplH();
        System.out.println(skillDAOImplH.getAll());
        numbersSkills = getParam("Number of skills");
        for (int i = 0; i < numbersSkills; i++) {
            skillList.add(skillDAOImplH.get(getParam("id of skill")));
        }
        return skillList;
    }*/

    @Override
    public void execute(Command command) {
        switch (command) {
            case CREATE:
                developersDAOImplH.create(createDeveloper());
                break;
            case READ:
                System.out.println(developersDAOImplH.get(getParam("id of developer")));
                break;
            case UPDATE:
                developersDAOImplH.update(createDeveloper(), getParam("id of developer"));
                break;
            case DELETE:
                developersDAOImplH.delete(getParam("id of developer"));
                break;
            case GET_ALL:
                developersDAOImplH.getAll().forEach(System.out::println);
                break;
            default:
                System.out.println("Not found command");
        }
    }
}
