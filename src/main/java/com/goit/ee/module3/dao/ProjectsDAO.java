package com.goit.ee.module3.dao;
import com.goit.ee.module3.dto.Project;
import java.util.List;

public interface ProjectsDAO extends DAO<Project> {
    List<Project> findByName(String nameProject);
    List<Project> findByCost(int cost);
}
