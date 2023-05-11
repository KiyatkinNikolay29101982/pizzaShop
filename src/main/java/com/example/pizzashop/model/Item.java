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
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @OneToOne
    @JoinColumn(name = ("pizza_id"))
    private Pizza pizza;

    @ManyToMany
    @JoinTable(name="item_addition",
            joinColumns = @JoinColumn(name="item_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name="addition_id", referencedColumnName = "id")
    )
    private List<Addition> additionList;

}
