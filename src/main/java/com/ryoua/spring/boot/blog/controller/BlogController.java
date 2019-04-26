package com.ryoua.spring.boot.blog.controller;

import com.ryoua.spring.boot.blog.entity.Blog;
import com.ryoua.spring.boot.blog.service.BlogService;
import com.ryoua.spring.boot.blog.utils.MarkDownToHtml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author ryoua Created on 2019-04-25
 */
@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;

    @GetMapping("/user/{username}/blogs/{id}")
    public String blog(@PathVariable("id") Long id, Model model) {
        Blog blog = blogService.getBlogById(id);
        blog.setContent(MarkDownToHtml.markDownToHtml(blog.getContent()));
        model.addAttribute("blogModel", blog);
        return "blog";
    }

    @GetMapping("/blogedit")
    public String blogEdit(Model model) {
        Blog blog = new Blog();
        model.addAttribute("blog", blog);
        return "blogedit";
    }

    @PostMapping("/uploadBlog")
    public String uploadBlog(Blog blog) {
        blog.setCreateTime(new Timestamp(new Date().getTime()));
        blogService.saveBlog(blog);
        return "redirect:/index";
    }
}
