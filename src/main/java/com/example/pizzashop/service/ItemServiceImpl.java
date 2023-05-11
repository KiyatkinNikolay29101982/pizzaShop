package com.example.pizzashop.service;

import com.example.pizzashop.model.Item;
import com.example.pizzashop.repository.ItemRepository;

import java.util.List;
import java.util.Optional;

public class ItemServiceImpl implements ItemService{
    private final ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public void delete(Item item) {
       itemRepository.delete(item);
    }

    @Override
    public List<Item> getAll() {
        return itemRepository.findAll();
    }

    @Override
    public Optional<Item> findById(Long id) {
        return itemRepository.findById(id);
    }

    @Override
    public void save(Item item) {
        itemRepository.save(item);
    }
}
