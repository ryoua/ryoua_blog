package com.ryoua.spring.boot.blog.service;

import com.ryoua.spring.boot.blog.entity.Comment;

import java.util.List;

/**
 * @Author ryoua Created on 2019-04-26
 */
public interface CommentService {
    List<Comment> getAllBlogsById(Long blogId);

    void saveComment(Comment comment);
}
