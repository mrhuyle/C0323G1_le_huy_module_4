package com.example.song.controller;

import com.example.song.dto.SongDto;
import com.example.song.model.Song;
import com.example.song.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.validation.Valid;

@Controller
public class SongController {
    @Autowired
    private ISongService songService;
    @GetMapping("/")
    public String showHomePage(Model model) {
        model.addAttribute("songDto",new SongDto());
        return "home";
    }

    public String create(@Valid @ModelAttribute SongDto songDto, BindingResult bindingResult) {
        Song song = new Song();
        new SongDto().validate(songDto,bindingResult);
        if (bindingResult.hasErrors()) {
            return "home";
        }
        BeanUtils.copyProperties(songDto, song);
        songService.create(song);
        return "home/add-success";
    }

}
