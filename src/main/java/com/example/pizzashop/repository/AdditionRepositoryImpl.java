package com.example.pizzashop.repository;

import com.example.pizzashop.model.Addition;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class AdditionRepositoryImpl implements AdditionRepository{
    private  final EntityManager entityManager;

    public AdditionRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void delete(Addition addition) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(addition);
        transaction.commit();
    }

    @Override
    public Optional<Addition> findById(Long id) {
        TypedQuery<Addition> query =
                entityManager.createQuery("select addition from Addition addition where addition.id =:id ", Addition.class);
        query.setParameter("id", id);
        return Optional.ofNullable(query.getSingleResult());
    }

    @Override
    public Optional<Addition> findByName(String name) {
        TypedQuery<Addition> query =
                entityManager.createQuery("select addition from Addition addition where addition.name =:name ", Addition.class);
        query.setParameter("name", name);
        return Optional.ofNullable(query.getSingleResult());
    }

    @Override
    public void save(Addition addition) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(addition);
        transaction.commit();

    }

    @Override
    public List<Addition> findAll() {
        TypedQuery<Addition> query = entityManager.createQuery("from Addition addition",Addition.class);
        return query.getResultList();
    }
}
