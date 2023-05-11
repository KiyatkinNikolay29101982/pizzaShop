package com.example.pizzashop.service;

import com.example.pizzashop.model.Addition;
import com.example.pizzashop.model.Person;

import java.util.List;
import java.util.Optional;

public interface AdditionService {
    List<Addition> getAll();

    public Optional<Addition> findById(Long id);

    public void save(Addition addition);

    Optional<Addition> getAdditionByName(String name);
}
