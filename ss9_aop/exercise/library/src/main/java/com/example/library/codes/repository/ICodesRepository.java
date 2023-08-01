package com.example.library.codes.repository;

import com.example.library.codes.model.Codes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ICodesRepository extends JpaRepository<Codes,Long> {
    @Query("SELECT c FROM Codes c WHERE c.code = ?1")
    Codes findByCode(String code);
}
