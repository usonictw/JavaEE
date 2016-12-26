package com.goit.ee.module2;

import com.goit.ee.module2.dao.DevelopersDAOImplH;
import com.goit.ee.module2.dao.SkillDAOImplH;
import com.goit.ee.module2.dto.Developer;
import com.goit.ee.module2.dto.Skill;
import com.goit.ee.module2.util.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Created by user on 16.12.2016.
 */
@SuppressWarnings({"ALL", "deprecation"})
public class HibernateRunner {


    public static void main(String[] args) {


        DevelopersDAOImplH developersDAOImplH = new DevelopersDAOImplH();
        SkillDAOImplH skillDAOImplH = new SkillDAOImplH();

        skillDAOImplH.getAll().forEach(System.out::println);
        System.out.println();
        developersDAOImplH.getAll().forEach(System.out::println);
        System.out.println();
        developersDAOImplH.delete(26);
        System.out.println();
        developersDAOImplH.getAll().forEach(System.out::println);

        // skillDAOImplH.delete(18);




    }
}
