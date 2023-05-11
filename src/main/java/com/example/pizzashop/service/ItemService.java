package com.example.pizzashop.service;

import com.example.pizzashop.model.Item;
import com.example.pizzashop.model.Pizza;

import java.util.List;
import java.util.Optional;

public interface ItemService {
    public void delete(Item item);
    List<Item> getAll();

    public Optional<Item> findById(Long id);

    public void save(Item item);
}
