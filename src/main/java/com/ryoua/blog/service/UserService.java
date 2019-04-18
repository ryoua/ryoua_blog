package com.ryoua.blog.service;

import com.ryoua.blog.domain.User;

/**
 * @Author ryoua Created on 2019-04-15
 */
public interface UserService {
    void saveUser(User user);

    boolean getUserByUsernameAndPassword(String username, String password);
}
