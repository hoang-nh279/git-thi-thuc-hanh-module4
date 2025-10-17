package com.codegym.baithithuchanhmodule4.repository;

import com.codegym.baithithuchanhmodule4.model.Category;
import com.codegym.baithithuchanhmodule4.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.domain.Pageable;

public interface IProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findByNameContainingAndCategoryAndPriceGreaterThanEqual(
            String name,
            Category category,
            Double price,
            Pageable pageable
    );
    Page<Product> findByNameContainingAndCategory(
            String name,
            Category category,
            Pageable pageable
    );

    Page<Product> findByNameContainingAndPriceGreaterThanEqual(
            String name,
            Double price,
            Pageable pageable
    );


    Page<Product> findByNameContaining(String name, Pageable pageable);
}
