package com.goit.ee.module2.dao;

import com.goit.ee.module2.dto.Project;

public interface ProjectsDAO extends DAO<Project> {
    void findByName(String nameProject);
}
