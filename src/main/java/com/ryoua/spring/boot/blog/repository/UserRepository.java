package com.ryoua.spring.boot.blog.repository;

import com.ryoua.spring.boot.blog.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author ryoua Created on 2019-04-24
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
