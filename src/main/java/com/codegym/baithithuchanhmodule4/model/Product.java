package com.codegym.baithithuchanhmodule4.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    private double price;

    @Column(nullable = false)
    private String status;

    @ManyToOne
    @JoinColumn(name = "id_loai_sp")
    private Category category;
}
