package com.example.pizzashop.servlet;

import com.example.pizzashop.model.Cart;
import com.example.pizzashop.model.Item;
import com.example.pizzashop.model.Person;
import com.example.pizzashop.repository.CartRepository;
import com.example.pizzashop.repository.CartRepositoryImpl;
import com.example.pizzashop.repository.ItemRepository;
import com.example.pizzashop.repository.ItemRepositoryImpl;
import com.example.pizzashop.service.CartService;
import com.example.pizzashop.service.CartServiceImpl;
import com.example.pizzashop.service.ItemService;
import com.example.pizzashop.service.ItemServiceImpl;
import javaMailUtil.MailSendler;
import org.hibernate.SessionFactory;

import javax.mail.MessagingException;
import javax.persistence.EntityManager;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;

@WebServlet("/delivery")
public class DeliveryServlet extends HttpServlet {
    SessionFactory sessionFactory;
    ItemRepository itemRepository;
    ItemService itemService;
    CartRepository cartRepository;
    CartService cartService;
    List<Item> list;
    Person person;

    MailSendler mailSendler;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext servletContext = config.getServletContext();
        sessionFactory = (SessionFactory) servletContext.getAttribute("sessionFactory");
        EntityManager entityManager = sessionFactory.createEntityManager();
        itemRepository = new ItemRepositoryImpl(entityManager);
        cartRepository = new CartRepositoryImpl(entityManager);
        itemService = new ItemServiceImpl(itemRepository);
        cartService = new CartServiceImpl(cartRepository);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("jsp/delivery.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        list = (List<Item>) req.getSession().getAttribute("pizzaListBuy");
        System.out.println(list);
        saveItems(list);
        person = (Person) req.getSession().getAttribute("user");
        String city = req.getParameter("city");
        String street = req.getParameter("street");
        String building = req.getParameter("building");

        Cart cart = Cart.builder()
                .person(person)
                .itemList(list)
                .city(city)
                .street(street)
                .building(building)
                .build();

        cartService.save(cart);
        try {
            mailSendler.sendMessage(person.getEmail());
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        PrintWriter out = resp.getWriter();
        out.println("Order complete");
        out.flush();
    }

    private void saveItems(List<Item> items){
        for(Item i : items){
            itemService.save(i);
        }
    }

}
