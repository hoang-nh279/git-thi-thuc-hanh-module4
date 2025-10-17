package com.codegym.baithithuchanhmodule4.service.impl;

import com.codegym.baithithuchanhmodule4.model.Category;
import com.codegym.baithithuchanhmodule4.model.Product;
import com.codegym.baithithuchanhmodule4.repository.ICategoryRepository;
import com.codegym.baithithuchanhmodule4.repository.IProductRepository;
import com.codegym.baithithuchanhmodule4.service.IProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;



import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    private final IProductRepository productRepository;
    private final ICategoryRepository categoryRepository;

    public ProductServiceImpl(IProductRepository productRepository, ICategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Page<Product> findAll(String name, Long categoryId, Double price, Pageable pageable) {
        Category category = null;
        if (categoryId != null) {
            category = categoryRepository.findById(categoryId).orElse(null);
        }

        if (category != null && price != null) {
            // Tìm theo tên + loại + giá
            return productRepository.findByNameContainingAndCategoryAndPriceGreaterThanEqual(name, category, price, pageable);
        } else if (category != null) {
            // Tìm theo tên + loại
            return productRepository.findByNameContainingAndCategory(name, category, pageable);
        } else if (price != null) {
            // Tìm theo tên + giá
            return productRepository.findByNameContainingAndPriceGreaterThanEqual(name, price, pageable);
        } else {
            // Tìm theo tên thôi
            return productRepository.findByNameContaining(name, pageable);
        }
    }


    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void deleteByIds(List<Long> ids) {
        productRepository.deleteAllById(ids);
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }
}
