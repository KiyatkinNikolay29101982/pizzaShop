package com.example.pizzashop.servlet;

import com.example.pizzashop.dto.LoginForm;
import com.example.pizzashop.model.Person;
import com.example.pizzashop.repository.PersonRepository;
import com.example.pizzashop.repository.PersonRepositoryImpl;
import com.example.pizzashop.service.LoginService;
import com.example.pizzashop.service.LoginServiceImpl;
import com.example.pizzashop.service.PersonService;
import com.example.pizzashop.service.PersonServiceImpl;
import com.example.pizzashop.util.HibernateUtil;
import org.hibernate.SessionFactory;

import javax.management.relation.Role;
import javax.persistence.EntityManager;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {


    SessionFactory sessionFactory;
    PersonRepositoryImpl personRepository;
    PersonService personService;

    Person person;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext servletContext = config.getServletContext();
        sessionFactory = (SessionFactory) servletContext.getAttribute("sessionFactory");
        EntityManager entityManager = sessionFactory.createEntityManager();
        personRepository = new PersonRepositoryImpl(entityManager);
        personService = new PersonServiceImpl( personRepository);


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("jsp/login.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        boolean isLogin = false;


        LoginForm form = LoginForm.builder()
                .login(req.getParameter("login"))
                .password(req.getParameter("password"))
                .build();
        Person.Role role = Person.Role.UNKNOW;

        LoginService loginService = new LoginServiceImpl(personRepository);

        if(loginService.doAuthentificate(form)){
            role = loginService.getRole(form);
            person = personService.getPersonByLogin(form.getLogin()).get();
        }


        session.setAttribute("user", person);

        session.setAttribute("isLogin", isLogin);

        session.setAttribute("role", role);

            if (role.equals(Person.Role.USER) ) {
                resp.sendRedirect("/pizzaPage");

            }
            if ( role.equals(Person.Role.ADMIN)) {
                resp.sendRedirect("/admin");

            }

            if (role.equals(Person.Role.UNKNOW)) {
                resp.sendRedirect("/registry");

            }



    }
}



