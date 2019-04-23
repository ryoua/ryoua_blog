package com.ryoua.blog.service.Impl;

import com.ryoua.blog.entity.Category;
import com.ryoua.blog.repository.CategoryRepository;
import com.ryoua.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author ryoua Created on 2019-04-23
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category findByName(String name) {
        return categoryRepository.findByName(name);
    }

    @Override
    public List<Category> list() {
        return categoryRepository.findAll();
    }
}
