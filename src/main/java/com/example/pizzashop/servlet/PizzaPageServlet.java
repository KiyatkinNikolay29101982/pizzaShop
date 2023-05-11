package com.example.pizzashop.servlet;

import com.example.pizzashop.model.Addition;
import com.example.pizzashop.model.Item;
import com.example.pizzashop.model.Pizza;
import com.example.pizzashop.repository.*;
import com.example.pizzashop.service.AdditionService;
import com.example.pizzashop.service.AdditionServiceImpl;
import com.example.pizzashop.service.PizzaService;
import com.example.pizzashop.service.PizzaServiceImpl;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

@WebServlet("/pizzaPage")
public class PizzaPageServlet extends HttpServlet {
    PizzaRepository pizzaRepository;
    AdditionRepository additionRepository;
    PizzaService pizzaService;
    AdditionService additionService;


    List<Pizza> pizzaList;
    List<Addition> additions;
    List<Item> pizzaListBuy;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        SessionFactory sessionFactory = (SessionFactory) context.getAttribute("sessionFactory");
        EntityManager entityManager = sessionFactory.createEntityManager();
        pizzaRepository = new PizzaRepositoryImpl(entityManager);
        additionRepository = new AdditionRepositoryImpl(entityManager);
        pizzaService = new PizzaServiceImpl(pizzaRepository);
        additionService = new AdditionServiceImpl(additionRepository);
        pizzaList = new CopyOnWriteArrayList<>();
        pizzaListBuy = new CopyOnWriteArrayList<>();
        additions = new CopyOnWriteArrayList<>();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        pizzaList = pizzaRepository.findAll();
        req.setAttribute("pizzaList", pizzaList);
        req.getRequestDispatcher("jsp/pizzaPage.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long pizzaId = Long.parseLong(req.getParameter("id"));

        String[] additionName = req.getParameterValues("addition");

        Pizza pizza = pizzaService.findById(pizzaId).get();

        Addition addition = additionService.getAdditionByName("olive").get();
        System.out.println(addition);
        List<Addition> topicForPizza = createAdditionList(additionName);
        Item item = Item.builder()
                .pizza(pizza)
                .additionList(topicForPizza)
                .build();

        pizzaListBuy.add(item);
        req.getSession().setAttribute("pizzaListBuy", pizzaListBuy);
        doGet(req, resp);

    }

    private List<Addition> createAdditionList(String[] additionName){
        List<Addition> list = new ArrayList<>();

        if(additionName != null) {
            for (int i = 0; i < additionName.length; i++) {
                String name = additionName[i];

                Optional<Addition> value = additionService.getAdditionByName(name);
                if(value.isPresent()){
                    Addition addition = value.get();
                    list.add(addition);
                    System.out.println(addition);
                }


            }
        }

        return list;
    }
}
