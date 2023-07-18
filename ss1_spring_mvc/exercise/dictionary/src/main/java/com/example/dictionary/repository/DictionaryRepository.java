package com.example.dictionary.repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class DictionaryRepository implements IDictionaryRepository {
    private static Map<String, String> dictionaryEn = new HashMap<>();
    private static Map<String, String> dictionaryVi = new HashMap<>();

    static {
        dictionaryEn.put("table", "ban");
        dictionaryEn.put("chair", "ghe");
        dictionaryVi.put("ban", "table");
        dictionaryVi.put("ghe", "chair");
    }


    @Override
    public String find(String word, String type) {
        String translateWord = "";
        System.out.println(type);
        if (type.equals("en")) {
            translateWord = dictionaryEn.get(word);
        } else if (type.equals("vi")) {
            translateWord = dictionaryVi.get(word);
        }
        if (translateWord == null) {
            translateWord = "Can not find the word";
            return translateWord;
        } else {
            return translateWord;
        }
    }
}
