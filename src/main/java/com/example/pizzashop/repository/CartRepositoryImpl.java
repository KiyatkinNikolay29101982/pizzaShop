package com.example.pizzashop.repository;

import com.example.pizzashop.model.Cart;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class CartRepositoryImpl implements CartRepository{
    private final EntityManager entityManager;

    public CartRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public void save(Cart cart) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(cart);
        entityManager.flush();
        transaction.commit();

    }

    @Override
    public List<Cart> findAll() {
        TypedQuery<Cart> query = entityManager.createQuery("from Cart cart",Cart.class);
        return query.getResultList();
    }

    @Override
    public void delete(Cart cart) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(cart);
        transaction.commit();
    }

    @Override
    public Optional<Cart> findById(Long id) {
        TypedQuery<Cart> query =
                entityManager.createQuery("select cart from Cart cart where cart.id =:id ", Cart.class);
        query.setParameter("id", id);
        return Optional.ofNullable(query.getSingleResult());
    }
}
