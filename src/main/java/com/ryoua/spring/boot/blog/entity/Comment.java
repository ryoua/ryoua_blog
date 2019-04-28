package com.ryoua.spring.boot.blog.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @Author ryoua Created on 2019-04-26
 */
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "blog_id")
    private Long blogId;

    @Column(name = "message_id")
    private Long messageId;

    @Column(name = "create_time")
    private Timestamp createTime;

    @Column
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBlogId() {
        return blogId;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", blogId=" + blogId +
                ", messageId=" + messageId +
                ", createTime=" + createTime +
                '}';
    }
}
