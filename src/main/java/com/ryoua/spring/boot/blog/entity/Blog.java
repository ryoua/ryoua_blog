package com.ryoua.spring.boot.blog.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @Author ryoua Created on 2019-04-25
 */
@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long blogId;

    @Column(name = "editor_name")
    private String username;

    @Column()
    private String summary;

    @Column()
    private String title;

    @Column()
    private Long hot;

    @Column()
    private String content;

    @Column(name = "create_time")
    private Timestamp createTime;

    @Column(name = "read_size")
    private Long readSize;

    public Long getReadSize() {
        return readSize;
    }

    public Long getHot() {
        return hot;
    }

    public void setHot(Long hot) {
        this.hot = hot;
    }

    public void setReadSize(Long readSize) {
        this.readSize = readSize;
    }

    public Long getBlogId() {
        return blogId;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "blogId=" + blogId +
                ", username='" + username + '\'' +
                ", summary='" + summary + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
