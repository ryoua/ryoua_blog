package com.ryoua.spring.boot.blog.service;

import com.ryoua.spring.boot.blog.entity.Blog;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @Author ryoua Created on 2019-04-25
 */
public interface BlogService {
    Blog getBlogById(Long id);

    List<Blog> getAllBlogs();

    List<Blog> getNewBlogs();

    List<Blog> getHotBlogs();

    void saveBlog(Blog blog);

    Page<Blog> findBlogNoCriteria(Integer page,Integer size);

}
