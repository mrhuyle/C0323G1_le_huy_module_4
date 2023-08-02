package com.example.blog.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String img;
    @OneToMany(mappedBy = "author")
    private Set<Blog> blogs;

    public Author() {
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Author(int id, String name, String img, Set<Blog> blogs) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.blogs = blogs;
    }

    public Author(String name, String img, Set<Blog> blogs) {
        this.name = name;
        this.img = img;
        this.blogs = blogs;
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

    public Set<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(Set<Blog> blogs) {
        this.blogs = blogs;
    }
}
