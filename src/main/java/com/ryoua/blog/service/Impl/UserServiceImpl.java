package com.ryoua.blog.service.Impl;

import com.ryoua.blog.entity.User;
import com.ryoua.blog.repository.UserRepository;
import com.ryoua.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author ryoua Created on 2019-04-22
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean login(String username, String password) {
        User user = userRepository.findByUsernameAndPassword(username, password);
        if (user == null)
            return false;
        else
            return true;
    }
}
