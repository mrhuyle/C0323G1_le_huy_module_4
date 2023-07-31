package com.example.library.books.model;

import com.example.library.codes.model.Codes;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private String description;
    private int totalCopies;
    private int availableCopies;
    private boolean flag;

    @OneToMany(mappedBy = "bookBorrowed")
    private Set<Codes> codes;

    public Books() {
    }

    public Books(String title, String author, String description, int totalCopies, int availableCopies, boolean flag) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.totalCopies = totalCopies;
        this.availableCopies = availableCopies;
        this.flag = flag;
    }

    public Books(Long id, String title, String author, String description, int totalCopies, int availableCopies, boolean flag) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.description = description;
        this.totalCopies = totalCopies;
        this.availableCopies = availableCopies;
        this.flag = flag;
    }

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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTotalCopies() {
        return totalCopies;
    }

    public void setTotalCopies(int totalCopies) {
        this.totalCopies = totalCopies;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(int availableCopies) {
        this.availableCopies = availableCopies;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
