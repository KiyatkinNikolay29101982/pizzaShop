package com.example.pizzashop.repository;

import com.example.pizzashop.model.Ingradient;

public interface InngradientRepository extends CRUDRepository<Ingradient>{
    void delete(Ingradient ingradient);

}
