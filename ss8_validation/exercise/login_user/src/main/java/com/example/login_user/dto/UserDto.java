package com.example.login_user.dto;

import java.time.LocalDate;

    public class UserDto {
        private String firstName;
        private String lastName;
        private String username;
        private String password;
        private String phoneNumber;
        private LocalDate dateOfBirth;
        private String email;
        private Gender gender;
        private Role role;

        // Constructors, getters, and setters

        public enum Gender {
            MALE, FEMALE, NON_BINARY
        }

        public enum Role {
            USER, ADMIN
        }
    }