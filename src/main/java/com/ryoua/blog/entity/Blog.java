package com.ryoua.blog.entity;

import javax.persistence.*;

/**
 * @Author ryoua Created on 2019-04-22
 */
@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

//    @Column(name = "read_size")
//    private String readSize;

    @ManyToOne
    private Category category;

    @Column(name = "summary", columnDefinition = "text")
    private String summary;

    @Column(name = "date", columnDefinition = "varchar(64)")
    private String date;

    public Blog() {}

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", category=" + category +
                ", summary='" + summary + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    public Blog(String title, String content, Category category, String summary, String date) {
        this.title = title;
        this.content = content;
        this.category = category;
        this.summary = summary;
        this.date = date;
    }

    //    public Blog(String title, String content, String readSize, Category category, String summary, String date) {
//        this.title = title;
//        this.content = content;
//        this.readSize = readSize;
//        this.category = category;
//        this.summary = summary;
//        this.date = date;
//    }

//    @Override
//    public String toString() {
//        return "Blog{" +
//                "id=" + id +
//                ", title='" + title + '\'' +
//                ", content='" + content + '\'' +
//                ", readSize='" + readSize + '\'' +
//                ", category=" + category +
//                ", summary='" + summary + '\'' +
//                ", date='" + date + '\'' +
//                '}';
//    }
//
//    public String getReadSize() {
//        return readSize;
//    }
//
//    public void setReadSize(String readSize) {
//        this.readSize = readSize;
//    }

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
