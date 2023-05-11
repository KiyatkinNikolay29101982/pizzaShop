package com.example.pizzashop.repository;

import com.example.pizzashop.model.Ingradient;
import com.example.pizzashop.model.Pizza;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class IngradientRepositoryImpl implements InngradientRepository{
    private final EntityManager entityManager;

    public IngradientRepositoryImpl(EntityManager entityManager) {

        this.entityManager = entityManager;
    }
    @Override
    public void save(Ingradient ingradient) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(ingradient);
        transaction.commit();
    }

    @Override
    public List<Ingradient> findAll() {
        TypedQuery<Ingradient> query = entityManager.createQuery("from Ingradient ingradient",Ingradient.class);
        return query.getResultList();
    }

    @Override
    public void delete(Ingradient ingradient) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(ingradient);
        transaction.commit();
    }
}
