package com.goit.ee.module3.dao;

import com.goit.ee.module3.dto.Skill;

import java.util.List;

public interface SkillsDAO extends DAO<Skill> {
    List<Skill> findByName(String nameSkills);
}
