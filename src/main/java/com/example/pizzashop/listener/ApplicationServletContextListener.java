package com.example.pizzashop.listener;

import com.example.pizzashop.util.HibernateUtil;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ApplicationServletContextListener implements ServletContextListener{
    SessionFactory sessionFactory;
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        sessionFactory = HibernateUtil.getSessionFactory();

        servletContext.setAttribute("sessionFactory", sessionFactory);

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
