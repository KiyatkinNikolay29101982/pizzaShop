package com.example.pizzashop.servlet;

import com.example.pizzashop.model.Person;
import com.example.pizzashop.repository.PersonRepository;
import com.example.pizzashop.repository.PersonRepositoryImpl;
import com.example.pizzashop.util.HibernateUtil;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
@WebServlet("/pageList")
public class PagePersonServlet extends HttpServlet {
    private List<Person> persons;
    SessionFactory sessionFactory;
    PersonRepository personRepository;
    @Override
    public void init(ServletConfig config) throws ServletException {
        persons = new CopyOnWriteArrayList<>();
//        ServletContext servletContext = config.getServletContext();
//        SessionFactory sessionFactory = (SessionFactory) servletContext.getAttribute("factory");
//        System.out.println(sessionFactory);

        sessionFactory = HibernateUtil.getSessionFactory();

        EntityManager entityManager = sessionFactory.createEntityManager();
        personRepository = new PersonRepositoryImpl(entityManager);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // req.setAttribute("persons", persons);
        req.getRequestDispatcher("jsp/li.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Person person = Person.builder()
                .firstName(req.getParameter("firstName"))
                .lastName(req.getParameter("lastName"))
                .login(req.getParameter("login"))
                .password(req.getParameter("password"))
                .email(req.getParameter("email"))
                .role(Person.Role.USER)
                .build();


                personRepository.save(person);
                persons.add(person);
                resp.sendRedirect("/login");

               // doGet(req, resp);

    }
}
