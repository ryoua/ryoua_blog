package com.ryoua.spring.boot.blog.controller;

import com.ryoua.spring.boot.blog.entity.Blog;
import com.ryoua.spring.boot.blog.entity.Comment;
import com.ryoua.spring.boot.blog.service.BlogService;
import com.ryoua.spring.boot.blog.service.CommentService;
import com.ryoua.spring.boot.blog.utils.MarkDownToHtml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * @Author ryoua Created on 2019-04-25
 */
@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;

    @Autowired
    private CommentService commentService;

    /**
     * 显示具体博客
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/user/ryoua/blogs/{id}")
    public String blog(@PathVariable("id") Long id, Model model) {
        // Blog Content
        Blog blog = blogService.getBlogById(id);
        blog.setContent(MarkDownToHtml.markDownToHtml(blog.getContent()));
        model.addAttribute("blogModel", blog);

        // Blog Hot
        blog.setHot(blog.getHot() + 1);
        blogService.saveBlog(blog);

        // Blog Comment
        Long blogId = blog.getBlogId();
        List<Comment> comments = commentService.getAllBlogsById(blogId);
        model.addAttribute("comments", comments);
        model.addAttribute("comment_size", comments.size());
        model.addAttribute("Comment", new Comment());
        return "blog";
    }

    /**
     * 评论上传
     * @param blogId
     * @param comment
     * @return
     */
    @PostMapping("/commentUpload/{id}")
    public String commentUpload(@PathVariable("id") Long blogId, Comment comment) {
        if (comment.getContent() == null || comment.getContent().equals(""))
            return "index";

        comment.setCreateTime(new Timestamp(new Date().getTime()));
        List<Comment> comments = commentService.getAllBlogsById(blogId);
        comment.setMessageId((long) (comments.size() + 1));
        comment.setBlogId(blogId);
        commentService.saveComment(comment);
        return "redirect:/user/ryoua/blogs/" + comment.getBlogId();
    }

    /**
     * 显示编辑博客页面
     * @param model
     * @return
     */
    @GetMapping("/blogedit")
    public String blogEdit(Model model) {
        Blog blog = new Blog();
        model.addAttribute("blog", blog);
        return "blogedit";
    }

    /**
     * 博客上传
     * @param blog
     * @return
     */
    @PostMapping("/uploadBlog")
    public String uploadBlog(Blog blog) {
        blog.setCreateTime(new Timestamp(new Date().getTime()));
        blog.setReadSize(1L);
        blog.setHot(1L);
        blog.setUsername("ryoua");
        blogService.saveBlog(blog);
        return "redirect:/index";
    }
}
