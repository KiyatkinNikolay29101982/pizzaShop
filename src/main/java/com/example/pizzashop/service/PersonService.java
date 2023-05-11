package com.example.pizzashop.service;

import com.example.pizzashop.model.Addition;
import com.example.pizzashop.model.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {
    List<Person> getAll();

    Person.Role getRole(String login, String password, Person person);

    void save(Person p);

    Optional<Person> getPersonByLogin(String l);



}
