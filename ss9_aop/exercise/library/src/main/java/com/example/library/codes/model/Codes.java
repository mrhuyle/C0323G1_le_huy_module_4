package com.example.library.codes.model;

import com.example.library.books.model.Books;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Codes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String code;

    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id" , nullable = false)
    private Books bookBorrowed;

    private LocalDate borrowedDate;
    private LocalDate returnDate;

    @Column(columnDefinition = "boolean default false")
    private boolean flag;

    @PrePersist
    private void generateCode() {
        // Generate a unique code using a combination of letters and numbers
        this.code = "B" + UUID.randomUUID().toString().replace("-", "").substring(0, 10);
    }
    public Codes() {
    }

    public Codes(Long id, String code, Books bookBorrowed, LocalDate borrowedDate, LocalDate returnDate, boolean flag) {
        this.id = id;
        this.code = code;
        this.bookBorrowed = bookBorrowed;
        this.borrowedDate = borrowedDate;
        this.returnDate = returnDate;
        this.flag = flag;
    }

    public Codes(String code, Books bookBorrowed, LocalDate borrowedDate, LocalDate returnDate, boolean flag) {
        this.code = code;
        this.bookBorrowed = bookBorrowed;
        this.borrowedDate = borrowedDate;
        this.returnDate = returnDate;
        this.flag = flag;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Books getBookBorrowed() {
        return bookBorrowed;
    }

    public void setBookBorrowed(Books bookBorrowed) {
        this.bookBorrowed = bookBorrowed;
    }

    public LocalDate getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrowedDate(LocalDate borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
