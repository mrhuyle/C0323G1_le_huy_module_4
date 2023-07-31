package com.example.library.codes.service;

import com.example.library.books.model.Books;
import com.example.library.codes.model.Codes;

import java.util.List;

public interface ICodesService {
    void borrow(Books book);
    List<Codes> findAll();
}
