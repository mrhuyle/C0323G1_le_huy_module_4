package com.example.dictionary.service;

import com.example.dictionary.repository.IDictionaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DictionaryService implements IDictionaryService {
    @Autowired
    private IDictionaryRepository dictionaryRepository;
    @Override
    public String find(String word, String type) {
        return dictionaryRepository.find(word, type);
    }
}
