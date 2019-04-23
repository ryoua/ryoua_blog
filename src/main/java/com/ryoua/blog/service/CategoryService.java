package com.ryoua.blog.service;

import com.ryoua.blog.entity.Category;

import java.util.List;

/**
 * @Author ryoua Created on 2019-04-23
 */
public interface CategoryService {
    Category findByName(String name);

    List<Category> list();
}
