package com.goit.ee.module2.contoller;

import com.goit.ee.module2.dao.DevelopersDAOImplH;
import com.goit.ee.module2.dao.SkillDAOImplH;
import com.goit.ee.module2.dto.Developer;
import com.goit.ee.module2.dto.Skill;

import static com.goit.ee.module2.contoller.Command.*;
import static com.goit.ee.module2.contoller.ConsoleUtils.getParam;
import static com.goit.ee.module2.contoller.ConsoleUtils.readParameter;

public class DeveloperController implements Executable {

    @Override
    public void execute(Command command) {
        DevelopersDAOImplH developersDAOImplH = new DevelopersDAOImplH();

        switch (command) {
            case CREATE:
                Developer developer = new Developer();
                developer.setFirstName(readParameter("first_name"));
                developer.setLastName(readParameter("last_name"));
                developer.setAge(getParam("age"));
                developer.setSalary(getParam("salary"));
                developer.addSkill(new SkillDAOImplH().get(1));
                developersDAOImplH.create(developer);

                break;
                case READ:
                    developersDAOImplH.get(getParam("id"));
                    break;
                case UPDATE:
                    developersDAOImplH.update(new Developer(
                            getParam("age"),
                            readParameter("first_name"),
                            readParameter("last_name"),
                            getParam("salary")));
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
