package com.codegym.musicuploaddemo.controller;

import com.codegym.musicuploaddemo.model.Song;
import com.codegym.musicuploaddemo.model.SongForm;
import com.codegym.musicuploaddemo.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/songs")
public class SongController {

    @Autowired
    private SongService songService;

    private final String UPLOAD_DIR = "uploads/";

    @GetMapping("/create")
    public String showForm(Model model) {
        model.addAttribute("songForm", new SongForm());
        return "create";
    }

    @PostMapping("/save")
    public String saveSong(@ModelAttribute SongForm songForm, Model model) throws IOException {

        MultipartFile file = songForm.getFile();
        String fileName = file.getOriginalFilename();

        if (!isValidFile(fileName)) {
            model.addAttribute("error", "Chỉ chấp nhận file .mp3, .wav, .ogg, .m4p");
            model.addAttribute("songForm", songForm);
            return "create";
        }

        File uploadDir = new File(UPLOAD_DIR);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        file.transferTo(new File(UPLOAD_DIR + fileName));

        Song song = new Song(
                songForm.getName(),
                songForm.getArtist(),
                songForm.getGenre(),
                UPLOAD_DIR + fileName
        );

        songService.save(song);

        return "redirect:/songs/list";
    }

    @GetMapping("/list")
    public String showList(Model model) {
        model.addAttribute("songs", songService.findAll());
        return "list";
    }

    private boolean isValidFile(String fileName) {
        if (fileName == null) return false;

        return fileName.endsWith(".mp3")
                || fileName.endsWith(".wav")
                || fileName.endsWith(".ogg")
                || fileName.endsWith(".m4p");
    }
}