package com.ryoua.blog.service.Impl;

import com.ryoua.blog.entity.Blog;
import com.ryoua.blog.repository.BlogRepository;
import com.ryoua.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author ryoua Created on 2019-04-23
 */
@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogRepository blogRepository;

    @Override
    public List<Blog> list() {
        return blogRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        blogRepository.delete(id);
    }

    @Override
    public Blog getById(Long id) {
        return blogRepository.getOne(id);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public List<Blog> getBlogByCategoryName(String category) {
        return blogRepository.findAllByCategoryName(category);
    }

    @Override
    public List<Blog> search(String key) {
        return blogRepository.findByTitleLike(key);
    }

//    @Override
//    public int getBlogReadSize(Long id) {
//        return blogRepository.countByReadSize(id);
//    }
}
