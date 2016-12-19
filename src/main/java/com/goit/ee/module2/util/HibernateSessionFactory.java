package com.goit.ee.module2.util;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//@SuppressWarnings("ALL")
public class HibernateSessionFactory {

    private static SessionFactory sessionFactory;

    static {

        try {
            //noinspection deprecation
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
