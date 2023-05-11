package com.example.pizzashop.repository;

import com.example.pizzashop.model.Pizza;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class PizzaRepositoryImpl implements PizzaRepository{
    private final EntityManager entityManager;

    public PizzaRepositoryImpl(EntityManager entityManager) {

        this.entityManager = entityManager;
    }
    @Override
    public void save(Pizza pizza) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(pizza);
        transaction.commit();
    }

    @Override
    public List<Pizza> findAll() {
        TypedQuery<Pizza> query = entityManager.createQuery("from Pizza pizza",Pizza.class);
        return query.getResultList();
    }

    @Override
    public void delete(Pizza pizza) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(pizza);
        transaction.commit();
    }

    @Override
    public Optional<Pizza> findById(Long id) {
        TypedQuery<Pizza> query =
                entityManager.createQuery("select pizza from Pizza pizza where pizza.id =:id ", Pizza.class);
                query.setParameter("id", id);
                return Optional.ofNullable(query.getSingleResult());
    }

    @Override
    public Optional<Pizza> findByname(String name) {
         TypedQuery<Pizza> query =
                entityManager.createQuery("select pizza from Pizza pizza where pizza.name =:name", Pizza.class);
        query.setParameter("name", name);
        return Optional.ofNullable(query.getSingleResult());
    }


}
