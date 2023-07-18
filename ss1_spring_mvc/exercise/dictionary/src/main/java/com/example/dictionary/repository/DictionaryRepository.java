package com.example.dictionary.repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class DictionaryRepository implements IDictionaryRepository{
    private static Map<String, String> dictionary = new HashMap<>();
    static {
        dictionary.put("table", "bàn");
        dictionary.put("chair", "ghế");
    }


    @Override
    public String find(String english) {
        String vietnamese = dictionary.get(english);
        return vietnamese;
    }
}
