package com.ryoua.blog.controller;

import com.ryoua.blog.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author ryoua Created on 2019-04-11
 */
@Controller
public class MainController {

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
    public String login_user(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            HttpServletRequest request) {
        if (username.equals("ryoua") && password.equals("123")) {
            request.getSession().setAttribute("userInfo", username + " - " + password);
            System.out.println("登录成功");
            return "redirect:/index";
        } else {
            request.getSession().removeAttribute("userInfo");
            System.out.println("登录失败");
            return "redirect:/login-error";
        }
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
    public String register() {
        return "register";
    }

//    @PostMapping
//    public String register(User user) {
//
//    }

    @GetMapping("/search")
    public String search() {
        return "search";
    }
}
