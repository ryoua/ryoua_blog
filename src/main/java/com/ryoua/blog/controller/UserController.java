package com.ryoua.blog.controller;

import com.ryoua.blog.config.WebSecurityConfig;
import com.ryoua.blog.entity.Blog;
import com.ryoua.blog.entity.Category;
import com.ryoua.blog.entity.User;
import com.ryoua.blog.service.BlogService;
import com.ryoua.blog.service.CategoryService;
import com.ryoua.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author ryoua Created on 2019-04-22
 */
@Controller
@RequestMapping("/admin")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private BlogService blogService;

    @Autowired
    private CategoryService categoryService;

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    /**
     * 主页
     *
     * @param model
     * @return
     */
    @RequestMapping("")
    public String admin(Model model) {
        List<Blog> blogs = blogService.list();
        model.addAttribute("blogs", blogs);
        return "admin/index";
    }





    /**
     * 删除
     *
     * @param id
     * @return
     */
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        blogService.delete(id);
        return "redirect:/admin";
    }

    /**
     * 发布页
     *
     * @param model
     * @return
     */
    @RequestMapping("/write")
    public String write(Model model) {
        List<Category> categories = categoryService.list();
        model.addAttribute("categories", categories);
        model.addAttribute("blog", new Blog());
        return "admin/write";
    }

    /**
     * 发布
     *
     * @param blog
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Blog blog) {
        String name = blog.getCategory().getName();
        Category category = categoryService.findByName(name);
        blog.setCategory(category);
        if (blog.getContent().length() > 40)
            blog.setSummary(blog.getContent().substring(0, 40));
        else
            blog.setSummary(blog.getContent().substring(0, blog.getContent().length()));
        blog.setDate(sdf.format(new Date()));
        blogService.save(blog);
        return "redirect:/admin";
    }

    @RequestMapping("/update/{id}")
    public String update(@PathVariable("id") Long id, Model model) {
        Blog blog = blogService.getById(id);
        model.addAttribute("target", blog);
        List<Category> categories = categoryService.list();
        model.addAttribute("categories", categories);
        model.addAttribute("blog", new Blog());
        return "admin/update";
    }
}
