package com.ryoua.blog.controller;

import com.ryoua.blog.entity.Blog;
import com.ryoua.blog.service.BlogService;
import com.ryoua.blog.util.IpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.tautua.markdownpapers.Markdown;

import javax.servlet.http.HttpServletRequest;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.List;

/**
 * @Author ryoua Created on 2019-04-23
 */
@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private BlogService blogService;

    @RequestMapping("/get/{id}")
    public String get(Model model, @PathVariable(name = "id") String id){
        return "index";
    }

    @RequestMapping("")
    public String list(Model model){
        List<Blog> blogs = blogService.list();
        model.addAttribute("blogs", blogs);
        return "front/index";
    }

    /*
    按类型显示博客
     */
    @RequestMapping("/column/{displayname}/{category}")
    public String column(@PathVariable("displayname") String dispalyname, @PathVariable("category") String category, Model model){
        model.addAttribute("blogs", blogService.getBlogByCategoryName(category));
        model.addAttribute("displayName", dispalyname);

        return "front/columnPage";
    }

    /**
     * 显示详细信息
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/detail/{id}")
    public String detail(@PathVariable("id") Long id, Model model, HttpServletRequest request){
//        // 检测ip
//        String ipAddress = IpUtil.getIpAddr(request);
//        blogService.getBlogReadSize(id);
//
//
//        if (ipAddress == )

        Blog blog = blogService.getById(id);
        System.out.println(blog.getId());
        Markdown markdown = new Markdown();
        try {
            StringWriter out = new StringWriter();
            markdown.transform(new StringReader(blog.getContent()), out);
            out.flush();
            blog.setContent(out.toString());
        } catch (org.tautua.markdownpapers.parser.ParseException e) {
            e.printStackTrace();
        }
        model.addAttribute("blog", blog);
        return "front/detail";
    }

    @RequestMapping("/search")
    public String search(String key, Model model){
        List<Blog> blogs = blogService.search(key);
        model.addAttribute("blogs", blogs);
        return "front/columnPage";
    }
}
