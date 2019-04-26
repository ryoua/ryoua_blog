package com.ryoua.spring.boot.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author ryoua Created on 2019-04-25
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @GetMapping
    public String admin() {
        return "admins/index";
    }
}
