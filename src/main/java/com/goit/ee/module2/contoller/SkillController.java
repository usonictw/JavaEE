package com.goit.ee.module2.contoller;

import com.goit.ee.module2.dto.Skill;

import static com.goit.ee.module2.contoller.ConsoleUtils.*;
import static com.goit.ee.module2.dao.SkillsDAOImpl.*;

public class SkillController implements Executable {

    private SkillsDAOImpl skillsDAO = new SkillsDAOImpl();

    @Override
    public void execute(Command command) {
        switch (command) {
            case CREATE:
                Skill skill = new Skill();
                skill.setName(readParameter(columnName));
                if (skillsDAO.create(skill)) {
                    System.out.println(skill.getName() + " is created");
                    skillsDAO.getAll().forEach(System.out::println);
                } else {
                    System.out.println(columnName + " is not created");
                }
                break;
            case READ:
                skillsDAO.get(getParam(columnId));
                break;
            case UPDATE:
                skillsDAO.update(new Skill(getParam(columnId),
                        readParameter(columnName)));
                skillsDAO.getAll().forEach(System.out::println);
                break;
            case DELETE:
                int byId = getParam(columnId);
                if (skillsDAO.delete(byId)) {
                    skillsDAO.getAll().forEach(System.out::println);
                } else {
                    System.out.println("Object not found");
                }
                break;
            case GET_ALL:
                skillsDAO.getAll().forEach(System.out::println);
                break;
            default:
                System.out.println("Not found command");
        }
    }
}
