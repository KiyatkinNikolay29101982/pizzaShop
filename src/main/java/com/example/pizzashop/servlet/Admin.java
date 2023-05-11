package com.example.pizzashop.servlet;

import com.example.pizzashop.model.Person;
import com.example.pizzashop.repository.PersonRepository;
import com.example.pizzashop.repository.PersonRepositoryImpl;
import com.example.pizzashop.util.HibernateUtil;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@WebServlet("/admin")

public class Admin extends HttpServlet {
    private List<Person> persons;
    SessionFactory sessionFactory;
    PersonRepository personRepository;

    @Override
    public void init() throws ServletException {
        persons = new CopyOnWriteArrayList<>();
        sessionFactory = HibernateUtil.getSessionFactory();
        EntityManager entityManager = sessionFactory.createEntityManager();
        personRepository = new PersonRepositoryImpl(entityManager);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        persons = personRepository.findAll();
        req.setAttribute("personsAdmin", persons);
        req.getRequestDispatcher("jsp/admin.jsp").forward(req,resp);
    }
}
