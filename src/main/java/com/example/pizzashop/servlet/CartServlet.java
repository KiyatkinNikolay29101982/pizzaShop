package com.example.pizzashop.servlet;

import com.example.pizzashop.model.Addition;
import com.example.pizzashop.model.Item;
import com.example.pizzashop.model.Person;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {
    List<Item> list;
    Person person;
    int totalCoast;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        list = (List<Item>) req.getSession().getAttribute("pizzaListBuy");
        person = (Person) req.getSession().getAttribute("user");
        totalCoast = getTotalCoast();
        req.setAttribute("totalCoast", totalCoast);
        req.setAttribute("pizzaItem", list );
        req.getRequestDispatcher("jsp/cart.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    private int getTotalCoast(){
        int sum = 0;

        for(Item i : list){
            sum += i.getPizza().getCoast();
            for(Addition addition : i.getAdditionList()){
                sum += addition.getCoast();
            }
        }

        return  sum;
   }
}
