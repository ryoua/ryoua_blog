package com.ryoua.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author ryoua Created on 2019-04-11
 */
@Controller
@RequestMapping("/users")
public class UserController {

    /**
     * 查询所用用户
     * @return
     */
    @GetMapping
    public ModelAndView list() {
        return new ModelAndView("users/list");
    }
}
