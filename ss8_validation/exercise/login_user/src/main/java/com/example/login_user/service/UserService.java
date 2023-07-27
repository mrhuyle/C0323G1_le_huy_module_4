package com.example.login_user.service;

import com.example.login_user.model.User;
import com.example.login_user.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public void create(User user) {
        userRepository.save(user);
    }
}
