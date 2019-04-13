package com.ryoua.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author ryoua Created on 2019-04-11
 */
@Controller
@RequestMapping("/u")
public class UserSpaceController {
    @GetMapping("/{username}")
    public String userSpace(@PathVariable("username") String username) {
        return "u";
    }

    @GetMapping("/{username}/blogs/{id}")
    public String listBlogsByOrder(@PathVariable("id") Long id) {
        return "/blog";
    }

    @GetMapping("/{username}/blogs")
    public String listBlogsByOrder(@PathVariable("username") String username,
                                   @RequestParam(value="order",required=false,defaultValue="new") String order,
                                   @RequestParam(value="category",required=false ) Long category,
                                   @RequestParam(value="keyword",required=false ) String keyword) {
        return "u";
    }

    @GetMapping("/{username}/blogs/edit")
    public String editBlog() {
        return "/blogedit";
    }
}
