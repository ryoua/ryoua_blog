package com.ryoua.spring.boot.blog.service;

import com.ryoua.spring.boot.blog.entity.User;
import com.ryoua.spring.boot.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author ryoua Created on 2019-04-24
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean isUserExist(String username, String password) {
        List<User> list = userRepository.findAll();
        for (User user : list) {
            if (user.getUsername().equals(username))
                if (user.getPassword().equals(password))
                    return true;
        }
        return false;
    }
}
