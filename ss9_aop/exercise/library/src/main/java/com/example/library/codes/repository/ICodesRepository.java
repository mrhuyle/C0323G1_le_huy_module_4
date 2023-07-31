package com.example.library.codes.repository;

import com.example.library.codes.model.Codes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICodesRepository extends JpaRepository<Codes,Long> {
}
