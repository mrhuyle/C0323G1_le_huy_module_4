package com.example.blog.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToMany(mappedBy = "category")
    private Set<Blog> blogList;

    public Category() {
    }

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Category(String name) {
        this.name = name;
    }

    public Category(int id, String name, Set<Blog> blogList) {
        this.id = id;
        this.name = name;
        this.blogList = blogList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Blog> getBlogList() {
        return blogList;
    }

    public void setBlogList(Set<Blog> blogList) {
        this.blogList = blogList;
    }
}
