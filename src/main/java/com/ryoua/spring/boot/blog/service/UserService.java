package com.ryoua.spring.boot.blog.service;

import com.ryoua.spring.boot.blog.entity.User;

/**
 * @Author ryoua Created on 2019-04-24
 */
public interface UserService {
    boolean isUserExist(String username, String password);

    User getUserByToken(String userToken);
}
