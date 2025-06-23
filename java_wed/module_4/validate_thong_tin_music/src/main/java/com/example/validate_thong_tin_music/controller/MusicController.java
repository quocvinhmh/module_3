package com.example.validate_thong_tin_music.controller;

import com.example.validate_thong_tin_music.model.Music;
import com.example.validate_thong_tin_music.service.IMusicService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/music")
public class MusicController {

    @Autowired
    private IMusicService musicService;

    @GetMapping
    public String showMusic(Model model) {
        model.addAttribute("musicList", musicService.getMusic());
        return "list";
    }

    @GetMapping("/add")
    public String showaddMusic(Model model) {
        model.addAttribute("music", new Music());
        return "add";
    }

    @PostMapping("/add")
    public String addMusic(@Valid @ModelAttribute("music") Music music,
                           BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "add";
        }
        musicService.save(music);
        return "redirect:/music";
    }

    @GetMapping("/edit/{id}")
    public String showedit(@PathVariable int id, Model model) {
        model.addAttribute("music", musicService.getMusicById(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String editMusic(@Valid @ModelAttribute("music") Music music,
                            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "edit";
        }
        musicService.save(music);
        return "redirect:/music";
    }
}
