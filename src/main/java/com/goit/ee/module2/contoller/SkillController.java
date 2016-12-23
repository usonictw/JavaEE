package com.goit.ee.module2.contoller;

import com.goit.ee.module2.dao.SkillDAOImplH;
import com.goit.ee.module2.dto.Skill;
import static com.goit.ee.module2.contoller.ConsoleUtils.*;

public class SkillController implements Executable {

    private SkillDAOImplH skillsDAO = new SkillDAOImplH();

    @Override
    public void execute(Command command) {
        switch (command) {
            case CREATE:
                Skill skill = new Skill();
                skill.setName(readParameter("name"));
                skillsDAO.create(skill);
                break;
            case READ:
                skillsDAO.get(getParam("id"));
                break;
            case UPDATE:
                skillsDAO.update(new Skill(getParam("id"),
                        readParameter("name")));
                skillsDAO.getAll().forEach(System.out::println);
                break;
            case DELETE:
                int byId = getParam("id");
                skillsDAO.delete(byId);

                break;
            case GET_ALL:
                skillsDAO.getAll().forEach(System.out::println);
                break;
            default:
                System.out.println("Not found command");
        }
    }
}
