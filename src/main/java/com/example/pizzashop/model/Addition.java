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
public class Addition implements Supplements {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "coast")
    private int coast;
//    @ManyToMany
//    @JoinTable(name="item_addition",
//        joinColumns = @JoinColumn(name="addition_id", referencedColumnName = "id"),
//        inverseJoinColumns = @JoinColumn(name="item_id", referencedColumnName = "id")
//    )
//    private List<Item> items;


}
