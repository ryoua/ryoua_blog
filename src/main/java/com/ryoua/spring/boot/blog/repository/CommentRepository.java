package com.ryoua.spring.boot.blog.repository;

import com.ryoua.spring.boot.blog.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author ryoua Created on 2019-04-26
 */
@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByBlogId(Long blogId);
}
