package com.example.novalearn.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.novalearn.entity.Category;

public interface CategoryDao extends JpaRepository<Category, Integer> {

}
