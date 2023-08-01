package com.example.library.books.service;

import com.example.library.books.model.Books;
import com.example.library.books.repository.IBooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksService implements IBooksService {
    @Autowired
    private IBooksRepository booksRepository;

    @Override
    public List<Books> findAll() {
        return booksRepository.findAll();
    }

    @Override
    public Books findById(Long id) {
        return booksRepository.findById(id).orElse(null);
    }

    @Override
    public void setCopies(Books book) {
        Books currentBook = booksRepository.findById(book.getId()).get();
        currentBook.setAvailableCopies(book.getAvailableCopies() - 1);
        booksRepository.save(currentBook);
    }

    @Override
    public void setBookReturn(Long id) {
        Books bookReturn = booksRepository.findById(id).get();
        bookReturn.setAvailableCopies(bookReturn.getAvailableCopies() + 1);
        booksRepository.save(bookReturn);
    }
}
