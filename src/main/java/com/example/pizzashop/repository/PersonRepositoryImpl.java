package com.example.pizzashop.repository;

import com.example.pizzashop.model.Person;
import com.example.pizzashop.model.Pizza;
import org.hibernate.Session;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class PersonRepositoryImpl implements PersonRepository{
    private final EntityManager entityManager;

    public PersonRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public void save(Person person) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(person);
        entityManager.flush();
        transaction.commit();


    }

    public List<Person> findAll(){
        //EntityTransaction transaction = entityManager.getTransaction();

        TypedQuery<Person> query = entityManager.createQuery("from Person person", Person.class);
        return query.getResultList();

    }
@Override
    public Optional<Person> findByLogin(String l){
       return   entityManager.unwrap(Session.class).createQuery("select p from Person p where p.login =:l", Person.class)
                .setParameter("l", l)
               .setFirstResult(0)
               .setMaxResults(1)
               .uniqueResultOptional();
    }

    @Override
    public Person.Role getRoleByLogin(String login) {
        TypedQuery<Person.Role> query =
                entityManager.createQuery(" select person.role from Person person where person.login like : login", Person.Role.class);
        query.setParameter("login", login);
        return Person.Role.USER;
    }

    @Override
    public Optional<Person> findById(Long id) {
        TypedQuery<Person> query =
                entityManager.createQuery("select person from Person person where person.id =:id ", Person.class);
        query.setParameter("id", id);
        return Optional.ofNullable(query.getSingleResult());
    }
}
