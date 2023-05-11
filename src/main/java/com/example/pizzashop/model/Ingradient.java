package com.example.pizzashop.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Ingradient implements Ingradients {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="coast")
    private int coast;
    @ManyToOne
    @JoinColumn(name = "custom_pizza_id", nullable = false)
    CustomPizza customPizza;

}
