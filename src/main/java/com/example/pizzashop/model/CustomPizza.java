package com.example.pizzashop.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@Builder
@Entity
public class CustomPizza extends Pizza{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name="name")
    private String name;
//    @OneToMany(mappedBy = "customPizza")
    //private List<Ingradient> ingradientsList;
    @Column(name = "coast")
    private int coast = getCoast();

//    public int getCoast(){
//        int summ = ingradientsList.stream()
//                .map(Ingradient::getCoast)
//                .reduce(0,(a, b)-> a + b);
//
//        return summ;
//    }

}
