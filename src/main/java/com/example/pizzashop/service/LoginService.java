package com.example.pizzashop.service;

import com.example.pizzashop.dto.LoginForm;
import com.example.pizzashop.model.Person;

import javax.management.relation.Role;

public interface LoginService {
    boolean doAuthentificate(LoginForm form);

    Person.Role getRole(LoginForm form);


}
