package com.ryoua.spring.boot.blog.repository;

import com.ryoua.spring.boot.blog.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author ryoua Created on 2019-05-09
 */
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * 根据用户名分页查询用户列表
     * @param name
     * @param pageable
     * @return
     */
    Page<User> findByNameLike(String name, Pageable pageable);

    User findByUsername(String username);
}

