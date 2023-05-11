package com.example.pizzashop.service;

import com.example.pizzashop.model.Addition;
import com.example.pizzashop.model.Pizza;

import java.util.List;
import java.util.Optional;

public interface PizzaService {

    public void delete(Pizza pizza);
    List<Pizza> getAll();

    public Optional<Pizza> findById(Long id);

    public void save(Pizza pizza);

    Optional<Pizza> getPersonByName(String name);
}
