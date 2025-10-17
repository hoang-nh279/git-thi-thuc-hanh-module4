package com.codegym.baithithuchanhmodule4.repository;

import com.codegym.baithithuchanhmodule4.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Long> {
}
