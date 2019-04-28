package com.ryoua.spring.boot.blog.service;

/**
 * @Author ryoua Created on 2019-04-24
 */
public interface UserService {
    boolean isUserExist(String username, String password);

}
