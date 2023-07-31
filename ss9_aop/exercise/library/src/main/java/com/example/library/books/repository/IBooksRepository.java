package com.example.library.books.repository;

import com.example.library.books.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBooksRepository extends JpaRepository<Books,Long> {

}
