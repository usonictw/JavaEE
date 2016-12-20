package com.goit.ee.module2.dao;

import com.goit.ee.module2.dto.Project;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by user on 20.12.2016.
 */
public class ProjectDAOImplH implements ProjectsDAO{

    private Session session;

    @Override
    public void create(Project project) {

    }

    @Override
    public Project get(long id) {
        return null;
    }

    @Override
    public void update(Project project) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public List<Project> findByName(String nameProject) {
        return null;
    }

    @Override
    public List<Project> findByCost(int cost) {
        return null;
    }
}
