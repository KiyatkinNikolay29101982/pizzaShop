package com.example.pizzashop.service;

import com.example.pizzashop.model.Addition;
import com.example.pizzashop.model.Person;
import com.example.pizzashop.repository.AdditionRepository;

import java.util.List;
import java.util.Optional;

public class AdditionServiceImpl implements AdditionService{
    private final AdditionRepository additionRepository;

    public AdditionServiceImpl(AdditionRepository additionRepository) {
        this.additionRepository = additionRepository;
    }


    @Override
    public List<Addition> getAll() {
        return additionRepository.findAll();
    }

    @Override
    public Optional<Addition> findById(Long id) {
        return additionRepository.findById(id);
    }

    @Override
    public void save(Addition addition) {
        additionRepository.save(addition);
    }

    @Override
    public Optional<Addition> getAdditionByName(String name) {
        return additionRepository.findByName(name);
    }
}
