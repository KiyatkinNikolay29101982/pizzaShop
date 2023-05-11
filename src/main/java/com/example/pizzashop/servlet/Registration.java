package com.example.pizzashop.servlet;

import com.example.pizzashop.model.Person;
import com.example.pizzashop.repository.PersonRepository;
import com.example.pizzashop.repository.PersonRepositoryImpl;
import com.example.pizzashop.service.PersonService;
import com.example.pizzashop.service.PersonServiceImpl;
import com.example.pizzashop.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/registry")
public class Registration extends HttpServlet {
    SessionFactory sessionFactory;
    PersonRepository personRepository;
    PersonService personService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext servletContext = config.getServletContext();
        sessionFactory = (SessionFactory) servletContext.getAttribute("sessionFactory");
        EntityManager entityManager = sessionFactory.createEntityManager();
        personRepository = new PersonRepositoryImpl(entityManager);
        personService = new PersonServiceImpl((PersonRepositoryImpl) personRepository);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("jsp/registr.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Person p = Person.builder()
                .firstName(req.getParameter("firstName"))
                .lastName(req.getParameter("lastName"))
                .email(req.getParameter("email"))
                .login(req.getParameter("login"))
                .password(req.getParameter("password"))
                .role(Person.Role.USER)
                .build();
        personService.save(p);

        req.getRequestDispatcher("/login").forward(req, resp);
    }
}
