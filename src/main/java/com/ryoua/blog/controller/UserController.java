package com.ryoua.blog.controller;

import com.ryoua.blog.config.WebSecurityConfig;
import com.ryoua.blog.entity.User;
import com.ryoua.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author ryoua Created on 2019-04-22
 */
@Controller
@RequestMapping("/admin")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login() {
        return "admin/login";
    }

    @RequestMapping(value = "/doLogin", method = RequestMethod.POST)
    public String doLogin(HttpServletResponse response, User user, Model model) {
        if (userService.login(user.getUsername(), user.getPassword())) {
            Cookie cookie = new Cookie(WebSecurityConfig.SESSION_KEY, user.toString());
            response.addCookie(cookie);
            model.addAttribute("user", user);
            System.out.println(cookie.getName());

            return "redirect:/admin";
        } else {
            model.addAttribute("error", "账号密码错误");
            System.out.println("failure");
            return "admin/login";
        }
    }

    // TODO
}
