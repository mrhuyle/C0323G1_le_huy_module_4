package com.example.login_user.repository;

import com.example.login_user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User,Integer> {

}
