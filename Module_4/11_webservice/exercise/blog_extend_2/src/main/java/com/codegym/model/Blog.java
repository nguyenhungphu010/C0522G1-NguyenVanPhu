package com.codegym.model;

import javax.persistence.*;

@Entity
@Table(name = "blog_infor")
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // generatedValue là xét value tự tăng;
    private int id;
    private String description;
    @Column(columnDefinition = "LONGTEXT")
    private String content;
    private String author;

    @ManyToOne
    @JoinColumn(name = "",referencedColumnName = "id")

    private Category category;

    public Blog(int id, String description, String content, String author) {
        this.id = id;
        this.description = description;
        this.content = content;
        this.author = author;
    }
    public Blog(String description, String content, String author) {
        this.description = description;
        this.content = content;
        this.author = author;
    }
    public Blog(int id, String description, String content, String author, Category category) {
        this.id = id;
        this.description = description;
        this.content = content;
        this.author = author;
        this.category = category;
    }

    public Blog() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
}
