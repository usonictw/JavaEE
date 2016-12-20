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

       Session session = HibernateSessionFactory.getSessionFactory().openSession();

       DevelopersDAOImplH developersDAOImplH = new DevelopersDAOImplH();
       SkillDAOImplH skillDAOImplH = new SkillDAOImplH();
       developersDAOImplH.setSession(session);
       skillDAOImplH.setSession(session);

       skillDAOImplH.getAll().forEach(System.out::println);

       Transaction tx = session.beginTransaction();
        skillDAOImplH.delete(18);

      /* Developer developer = new Developer();
       developer.setAge(23);
       developer.setFirstName("Ivan");
       developer.setLastName("Ivanov");
       developer.setSalary(23000);

       Skill skill = new Skill();
       skill.setName("C");
       developer.addSkill(skill);

       session.save(developer);
       */
       tx.commit();
       session.close();






    }
}
