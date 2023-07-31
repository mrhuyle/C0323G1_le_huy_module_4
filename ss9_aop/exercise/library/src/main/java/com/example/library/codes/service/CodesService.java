package com.example.library.codes.service;

import com.example.library.books.model.Books;
import com.example.library.codes.model.Codes;
import com.example.library.codes.repository.ICodesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CodesService implements ICodesService {
    @Autowired
    private ICodesRepository codesRepository;

    @Override
    public void borrow(Books book) {
        Codes code = new Codes();
        code.setBookBorrowed(book);
        code.setBorrowedDate(LocalDate.now());
        code.setReturnDate(LocalDate.now().plusDays(14));
        codesRepository.save(code);
    }

    @Override
    public List<Codes> findAll() {
        return codesRepository.findAll();
    }
}
