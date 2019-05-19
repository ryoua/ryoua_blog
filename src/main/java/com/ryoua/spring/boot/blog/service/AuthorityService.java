package com.ryoua.spring.boot.blog.service;

import com.ryoua.spring.boot.blog.domain.Authority;

/**
 * @Author ryoua Created on 2019-05-09
 */
public interface AuthorityService {


    /**
     * 根据id获取 Authority
     */
    Authority getAuthorityById(Long id);
}
