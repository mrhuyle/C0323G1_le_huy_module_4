package com.example.library.books.service;

import com.example.library.books.model.Books;

import java.util.List;

public interface IBooksService {
    List<Books> findAll();

    Books findById(Long id);

    void setCopies(Books book);
    void setBookReturn(Long id);
}
