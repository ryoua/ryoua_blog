package com.ryoua.spring.boot.blog.service;

import com.ryoua.spring.boot.blog.entity.Blog;
import com.ryoua.spring.boot.blog.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author ryoua Created on 2019-04-25
 */
@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogRepository blogRepository;

    @Override
    public Blog getBlogById(Long id) {
        return blogRepository.getOne(id);
    }

    @Override
    public List<Blog> getHotBlogs() {
        return blogRepository.getHotBlogs();
    }

    @Override
    public void saveBlog(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public List<Blog> getNewBlogs() {
        return blogRepository.getNewBlogs();
    }

    @Override
    public List<Blog> getAllBlogs() {
        return blogRepository.findAll();
    }
}
