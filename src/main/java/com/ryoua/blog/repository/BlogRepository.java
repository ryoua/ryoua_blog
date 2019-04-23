package com.ryoua.blog.repository;

import com.ryoua.blog.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author ryoua Created on 2019-04-23
 */
@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {
    List<Blog> findAllByCategoryName(String name);

    List<Blog> findByTitleLike(String title);

//    int countByReadSize(Long id);
}
