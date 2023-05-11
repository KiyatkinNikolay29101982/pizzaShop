package com.example.pizzashop.repository;

import com.example.pizzashop.model.Pizza;

import java.util.Optional;

public interface PizzaRepository extends CRUDRepository<Pizza>{
    void delete(Pizza pizza);

    Optional<Pizza> findById(Long id);

    Optional<Pizza> findByname(String name);

}
