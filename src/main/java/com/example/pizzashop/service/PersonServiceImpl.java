package com.example.pizzashop.service;

import com.example.pizzashop.model.Person;
import com.example.pizzashop.repository.PersonRepository;
import com.example.pizzashop.repository.PersonRepositoryImpl;

import java.util.List;
import java.util.Optional;

public class PersonServiceImpl implements PersonService{
   private final PersonRepositoryImpl personRepository;

    public PersonServiceImpl(PersonRepositoryImpl personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> getAll() {
        return personRepository.findAll();
    }

    @Override
    public  Person.Role getRole(String login, String password, Person p ) {

        if (p.getLogin().equals(login) && p.getPassword().equals(password))
                return p.getRole();


        return null;
    }

    public void save(Person p){

        personRepository.save(p);
    }

    @Override
    public Optional<Person> getPersonByLogin(String l) {
        return personRepository.findByLogin(l);
    }

}
