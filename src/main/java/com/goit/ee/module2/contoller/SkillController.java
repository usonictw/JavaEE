package com.goit.ee.module2.contoller;

import com.goit.ee.module2.dao.SkillsDAOImpl;
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
                skillsDAO.create(skill);
                break;
            case READ:
                skillsDAO.get(getParam(columnId));
                break;
            case UPDATE:
                skillsDAO.update(new Skill(getParam(columnId),
                        readParameter(columnName)));
                break;
            case DELETE:
                skillsDAO.delete(getParam(columnId));
                break;
        }
    }
}
