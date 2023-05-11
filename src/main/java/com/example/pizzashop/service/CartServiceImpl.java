package com.example.pizzashop.service;

import com.example.pizzashop.model.Cart;
import com.example.pizzashop.model.Item;
import com.example.pizzashop.repository.CartRepository;

import java.util.List;
import java.util.Optional;

public class CartServiceImpl implements CartService{
    private final CartRepository cartRepository;

    public CartServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public void delete(Cart cart) {
        cartRepository.delete(cart);
    }

    @Override
    public List<Cart> getAll() {
        return cartRepository.findAll();
    }

    @Override
    public void save(Cart cart) {
        cartRepository.save(cart);
    }


    @Override
    public Optional<Cart> findById(Long id) {
        return cartRepository.findById(id);
    }
}
