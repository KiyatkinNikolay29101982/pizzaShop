package com.example.pizzashop.service;

import com.example.pizzashop.model.Pizza;
import com.example.pizzashop.repository.PizzaRepository;

import java.util.List;
import java.util.Optional;

public class PizzaServiceImpl implements PizzaService{
    private final PizzaRepository pizzaRepository;

    public PizzaServiceImpl(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    @Override
    public void delete(Pizza pizza) {
        pizzaRepository.delete(pizza);

    }

    @Override
    public List<Pizza> getAll() {
        return pizzaRepository.findAll();
    }

    @Override
    public Optional<Pizza> findById(Long id) {
        return pizzaRepository.findById(id);
    }

    @Override
    public void save(Pizza pizza) {
        pizzaRepository.save(pizza);
    }

    @Override
    public Optional<Pizza> getPersonByName(String name) {
        return pizzaRepository.findByname(name);
    }
}
