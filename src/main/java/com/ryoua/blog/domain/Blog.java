package com.ryoua.blog.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

/**
 * @Author ryoua Created on 2019-04-11
 */
//@Table(name = "blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 用户ID
    private String title; // 标题
    private String summary; // 摘要
    private String content;
    private String htmlContent; // md转html
    private User user;
    private Timestamp createTime;
    private Integer readSize; // 访问量
    private Integer commentSize = 0; // 评论量
    private Integer likeSize = 0; // 点赞量

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getHtmlContent() {
        return htmlContent;
    }

    public void setHtmlContent(String htmlContent) {
        this.htmlContent = htmlContent;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Integer getReadSize() {
        return readSize;
    }

    public void setReadSize(Integer readSize) {
        this.readSize = readSize;
    }

    public Integer getCommentSize() {
        return commentSize;
    }

    public void setCommentSize(Integer commentSize) {
        this.commentSize = commentSize;
    }

    public Integer getLikeSize() {
        return likeSize;
    }

    public void setLikeSize(Integer likeSize) {
        this.likeSize = likeSize;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", content='" + content + '\'' +
                ", htmlContent='" + htmlContent + '\'' +
                ", user=" + user +
                ", createTime=" + createTime +
                ", readSize=" + readSize +
                ", commentSize=" + commentSize +
                ", likeSize=" + likeSize +
                '}';
    }
}
