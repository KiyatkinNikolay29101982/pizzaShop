package com.example.pizzashop.repository;

import com.example.pizzashop.model.Person;
;import java.util.List;
import java.util.Optional;

public interface PersonRepository extends CRUDRepository<Person> {
    List<Person> findAll();

    Optional<Person> findByLogin(String login);

    Person.Role getRoleByLogin(String login);

    Optional<Person> findById(Long id);
}
