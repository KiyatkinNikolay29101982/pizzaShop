package com.example.pizzashop.repository;

import java.util.List;

public interface CRUDRepository <T>{
    void save(T t);
    List<T> findAll();
}
