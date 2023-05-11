package com.example.pizzashop.service;

import com.example.pizzashop.dto.LoginForm;
import com.example.pizzashop.model.Person;
import com.example.pizzashop.repository.PersonRepositoryImpl;

import javax.management.relation.Role;

public class LoginServiceImpl implements LoginService {
    PersonRepositoryImpl repository;


    public LoginServiceImpl(PersonRepositoryImpl repository){
        this.repository = repository;
    }

    @Override
    public boolean doAuthentificate(LoginForm form) {
        if(repository.findByLogin(form.getLogin()).isPresent()) {
            return repository.findByLogin(form.getLogin()).get().getPassword().equals(form.getPassword());
        }

        return false;
    }


    @Override
    public Person.Role getRole(LoginForm form) {
        return repository.getRoleByLogin(form.getLogin());
    }


}
