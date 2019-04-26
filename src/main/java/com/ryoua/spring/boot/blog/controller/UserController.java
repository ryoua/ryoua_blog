package com.ryoua.spring.boot.blog.controller;

import com.ryoua.spring.boot.blog.entity.Blog;
import com.ryoua.spring.boot.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ryoua Created on 2019-04-26
 */
@Controller
@RequestMapping("/user/ryoua")
public class UserController {
    @Autowired
    private BlogService blogService;

    @GetMapping("")
    public String userspace(Model model) {
        List<Blog> list = new ArrayList<>(blogService.getNewBlogs());
        model.addAttribute("blogList", list);
        return "user";
    }
}
