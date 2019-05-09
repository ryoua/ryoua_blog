package com.ryoua.spring.boot.blog.service.Impl;

import com.ryoua.spring.boot.blog.domain.Authority;
import com.ryoua.spring.boot.blog.repository.AuthorityRepository;
import com.ryoua.spring.boot.blog.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author ryoua Created on 2019-05-09
 */
@Service
public class AuthorityServiceImpl  implements AuthorityService {

    @Autowired
    private AuthorityRepository authorityRepository;

    @Override
    public Authority getAuthorityById(Long id) {
        return authorityRepository.findOne(id);
    }

}
