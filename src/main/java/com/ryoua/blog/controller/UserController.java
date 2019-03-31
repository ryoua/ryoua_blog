package com.ryoua.blog.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author ryoua Created on 2019/3/31
 */
@RestController
@RequestMapping("/users")
public class UserController {


    @GetMapping
    public ModelAndView list() {

        return new ModelAndView("users/list");
    }



}
