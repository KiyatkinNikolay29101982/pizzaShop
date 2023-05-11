package com.example.pizzashop.service;

import com.example.pizzashop.model.Cart;
import com.example.pizzashop.model.Item;

import java.util.List;
import java.util.Optional;

public interface CartService {
    public void delete(Cart cart);
    List<Cart> getAll();

    public void save(Cart cart);

    public Optional<Cart> findById(Long id);
}
