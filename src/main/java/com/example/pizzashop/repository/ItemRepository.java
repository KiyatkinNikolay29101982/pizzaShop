package com.example.pizzashop.repository;

import com.example.pizzashop.model.Addition;
import com.example.pizzashop.model.Item;

import java.util.Optional;

public interface ItemRepository extends CRUDRepository<Item>{
    void delete(Item item);

    Optional<Item> findById(Long id);


}
