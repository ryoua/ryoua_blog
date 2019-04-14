package com.ryoua.blog.repository;

import com.ryoua.blog.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author ryoua Created on 2019-04-13
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
