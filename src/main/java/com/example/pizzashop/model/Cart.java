package com.example.pizzashop.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "city")
    private String city;

    @Column(name="street")
    private String street;
    @Column(name="building")
    private String building;
    @OneToOne
    @JoinColumn(name = "person_id")
    private Person person;
    @OneToMany
    private List<Item> itemList;
}



