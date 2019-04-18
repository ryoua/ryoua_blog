package com.ryoua.blog.controller;

import com.ryoua.blog.domain.User;
import com.ryoua.blog.repository.UserRepository;
import com.ryoua.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author ryoua Created on 2019-04-11
 */
@Controller
public class MainController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String root() {
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String login_user(User user) {
        if (userService.getUserByUsernameAndPassword(user.getUsername(), user.getPassword())) {
            return "redirect:/index";
        }
        return "redirect:/login-error";
    }

    @GetMapping("/login-out")
    public String log_out(
            HttpServletRequest request) {
        request.getSession().removeAttribute("userInfo");
        return "index";
    }

    @GetMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        model.addAttribute("errorMsg", "登录失败, 账号或密码错误");
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "register";

    }

    @PostMapping("/register")
    public String register(User user) {
        userService.saveUser(user);
        return "redirect:/login";
    }

    @GetMapping("/search")
    public String search() {
        return "search";
    }
}
