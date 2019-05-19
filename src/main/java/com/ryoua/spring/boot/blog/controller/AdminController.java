package com.ryoua.spring.boot.blog.controller;

import com.ryoua.spring.boot.blog.vo.Menu;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ryoua Created on 2019-05-09
 */
@Controller
@RequestMapping("/admins")
public class AdminController {
    /**
     * 获取后台管理主页面
     */
    @GetMapping
    public ModelAndView listUsers(Model model) {
        List<Menu> list = new ArrayList<>();
        list.add(new Menu("用户管理", "/users"));
        list.add(new Menu("角色管理", "/roles"));
        list.add(new Menu("博客管理", "/blogs"));
        list.add(new Menu("评论管理", "/commits"));
        model.addAttribute("list", list);
        return new ModelAndView("/admins/index", "model", model);
    }
}
