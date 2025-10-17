package com.codegym.baithithuchanhmodule4.service;

import com.codegym.baithithuchanhmodule4.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface IProductService {
    Page<Product> findAll(String name, Long categoryId, Double price, Pageable pageable);
    void save(Product product);
    void deleteByIds(List<Long> ids);
    Product findById(Long id);
}
