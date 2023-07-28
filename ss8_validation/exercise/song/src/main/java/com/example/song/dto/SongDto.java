package com.example.song.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Pattern;

public class SongDto implements Validator {
    @Pattern(regexp = "^(?!.*[!@#$%^&*()_+={}|\\[\\]\\\\';:\"<>?,./])(?!\\s).{1,799}$", message = "Wrong input regex: ^(?!.*[!@#$%^&*()_+={}|\\[\\]\\\\';:\"<>?,./])(?!\\s).{1,799}$ ")
    private String name;
    @Pattern(regexp = "^(?!.*[!@#$%^&*()_+={}|\\[\\]\\\\';:\"<>?,./])(?!\\s).{1,299}$", message = "Wrong input regex: ^(?!.*[!@#$%^&*()_+={}|\\[\\]\\\\';:\"<>?,./])(?!\\s).{1,299}$ ")
    private String artist;
    @Pattern(regexp = "^(?!.*[!@#$%^&*()_+={}|\\[\\]\\\\';:\"<>?./])(?!\\s).{1,999}$", message = "Wrong input regex: ^(?!.*[!@#$%^&*()_+={}|\\[\\]\\\\';:\"<>?./])(?!\\s).{1,999}$ ")
    private String genre;

    public SongDto(String name, String artist, String genre) {
        this.name = name;
        this.artist = artist;
        this.genre = genre;
    }

    public SongDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
