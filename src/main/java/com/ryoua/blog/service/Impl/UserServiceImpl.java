package com.ryoua.blog.service.Impl;

import com.ryoua.blog.domain.User;
import com.ryoua.blog.repository.UserRepository;
import com.ryoua.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ryoua Created on 2019-04-18
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean getUserByUsernameAndPassword(String username, String password) {
        List<User> userList = userRepository.findAll();
        for (User user : userList) {
            if (user.getUsername().equals(username)) {
                if (user.getPassword().equals(password))
                    return true;
            }
        }
        return false;
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }
}
