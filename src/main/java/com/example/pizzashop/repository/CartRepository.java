package com.example.pizzashop.repository;

import com.example.pizzashop.model.Cart;
import com.example.pizzashop.model.Cart;

import java.util.Optional;

public interface CartRepository extends CRUDRepository<Cart>{
    void delete(Cart cart);

    Optional<Cart> findById(Long id);
}
