package com.ryoua.spring.boot.blog.service;

import com.ryoua.spring.boot.blog.entity.Comment;
import com.ryoua.spring.boot.blog.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Transient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author ryoua Created on 2019-04-26
 */
@Service
public class CommentServiceImpl implements CommentService{
    @Autowired
    private CommentRepository commentRepository;

    @Transactional
    @Override
    public void saveComment(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public List<Comment> getAllBlogsById(Long blogId) {
        return commentRepository.findAllByBlogId(blogId);
    }
}
