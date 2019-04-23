package com.ryoua.blog.service;

import com.ryoua.blog.entity.Blog;

import java.util.List;

/**
 * @Author ryoua Created on 2019-04-23
 */
public interface BlogService {
    List<Blog> list();

    void delete(Long id);

    Blog getById(Long id);

    void save(Blog blog);

    List<Blog> search(String key);

    List<Blog> getBlogByCategoryName(String category);

//    int getBlogReadSize(Long id);
}
