package com.codegym.baithithuchanhmodule4.service.impl;

import com.codegym.baithithuchanhmodule4.model.Category;
import com.codegym.baithithuchanhmodule4.repository.ICategoryRepository;
import com.codegym.baithithuchanhmodule4.service.ICategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {

    private final ICategoryRepository categoryRepository;

    public CategoryServiceImpl(ICategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
