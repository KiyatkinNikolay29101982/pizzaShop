package com.example.pizzashop.repository;

import com.example.pizzashop.model.Addition;
import com.example.pizzashop.model.Pizza;

import java.util.List;
import java.util.Optional;

public interface AdditionRepository extends CRUDRepository<Addition> {
    void delete(Addition addition);

    Optional<Addition> findById(Long id);

   Optional<Addition> findByName(String name);

}
