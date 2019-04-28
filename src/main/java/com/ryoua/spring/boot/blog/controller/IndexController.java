package com.ryoua.spring.boot.blog.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ryoua.spring.boot.blog.entity.Blog;
import com.ryoua.spring.boot.blog.entity.User;
import com.ryoua.spring.boot.blog.service.BlogService;
import com.ryoua.spring.boot.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ryoua Created on 2019-04-25
 */
@Controller
public class IndexController {
    @Autowired
    private UserService userService;

    @Autowired
    private BlogService blogService;

    @GetMapping("/")
    public String root() {
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String index(Model model) {
        List<Blog> newBlogs = blogService.getNewBlogs();
        List<Blog> hotBlogs = blogService.getHotBlogs();
        List<Blog> allBlogs = blogService.getAllBlogs();

        model.addAttribute("blogList", allBlogs);
        model.addAttribute("newBlogs", newBlogs);
        model.addAttribute("hotBlogs", hotBlogs);
        return "index";
    }

//    @GetMapping("/index/{pageId}")
//    public String indexByPage(@PathVariable("pageId") int pageId, Model model){
////        Page<Blog> blogList = blogService.findBlogNoCriteria(pageId, 4);
//        List<Blog> newBlogs = blogService.getNewBlogs();
//        List<Blog> hotBlogs = blogService.getHotBlogs();
//
//        List<Blog> allBlogs = blogService.getAllBlogs();
//        List<Blog> blogList = new ArrayList<>();
//        int length = pageId * 4;
//        for (int i = 0; i < allBlogs.size(); i++) {
//            if (i >= (pageId - 1) * 4 && i <= length)
//                blogList.add(allBlogs.get(allBlogs.size() - i));
//        }
//
//        model.addAttribute("blogList", blogList);
//        model.addAttribute("newBlogs", newBlogs);
//        model.addAttribute("hotBlogs", hotBlogs);
//        return "index";
//    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String doLogin(User user) {
        boolean exist = userService.isUserExist(user.getUsername(), user.getPassword());
        if (exist)
            return "redirect:/index";
        else
            return "redirect:/login-error";
    }

    @GetMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        model.addAttribute("errorMsg", "登陆失败，用户名或者密码错误！");
        return "login";
    }

    @GetMapping("/user/{username}")
    public String user(@PathVariable("username") String username) {
        return "user";
    }
}
