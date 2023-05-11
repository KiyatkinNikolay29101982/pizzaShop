package com.example.pizzashop.repository;

import com.example.pizzashop.model.Addition;
import com.example.pizzashop.model.Item;
import com.example.pizzashop.model.Pizza;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class ItemRepositoryImpl implements ItemRepository{
    private  final EntityManager entityManager;

    public ItemRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(Item item) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(item);
        transaction.commit();
    }

    @Override
    public List<Item> findAll() {
        TypedQuery<Item> query = entityManager.createQuery("from Item item",Item.class);
        return query.getResultList();
    }

    @Override
    public void delete(Item item) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(item);
        transaction.commit();

    }

    @Override
    public Optional<Item> findById(Long id) {
        TypedQuery<Item> query = entityManager.createQuery("select  item from Item item where item.id =: id",Item.class);
        query.setParameter("id",id);
        return Optional.ofNullable(query.getSingleResult());
    }
}
