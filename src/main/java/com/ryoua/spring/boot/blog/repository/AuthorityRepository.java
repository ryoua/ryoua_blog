package com.ryoua.spring.boot.blog.repository;

import com.ryoua.spring.boot.blog.domain.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author ryoua Created on 2019-05-09
 */
public interface AuthorityRepository extends JpaRepository<Authority, Long> {
}
