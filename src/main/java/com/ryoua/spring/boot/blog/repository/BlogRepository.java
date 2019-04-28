package com.ryoua.spring.boot.blog.repository;

import com.ryoua.spring.boot.blog.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author ryoua Created on 2019-04-25
 */
@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {
    @Query(value = "select * from blog order by create_time desc limit 5", nativeQuery = true)
    List<Blog> getNewBlogs();

    @Query(value = "select * from blog order by hot desc limit 5", nativeQuery = true)
    List<Blog> getHotBlogs();
}
