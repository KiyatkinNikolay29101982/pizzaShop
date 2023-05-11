package com.example.pizzashop.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    public static SessionFactory sessionFactory;
    private HibernateUtil(){

    }

    public static synchronized SessionFactory getSessionFactory(){
        if(sessionFactory == null) {
           Configuration configuration = new Configuration();
           configuration.configure("hibernate\\hibernate.cfg.xml");
           sessionFactory = configuration.buildSessionFactory();
        }

        return sessionFactory;
    }
}
