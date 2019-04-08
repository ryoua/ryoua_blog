package com.ryoua.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Blog 控制器
 * @Author ryoua Created on 2019/3/31
 */
@Controller
@RequestMapping("/blogs")
public class BlogController {
    @GetMapping
    public String listBlogs(
            @RequestParam(value = "order", required = false, defaultValue = "new") String order,
            @RequestParam(value = "keyword", required = false) String keyword) {
        return "redirect:/index?order=" + order + "&keyward=" + keyword;
    }
}
