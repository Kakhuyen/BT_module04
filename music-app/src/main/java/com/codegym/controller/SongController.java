package com.codegym.controller;

import com.codegym.model.Song;
import com.codegym.model.SongForm;
import com.codegym.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

@Controller
@RequestMapping("/songs")
public class SongController {

    @Autowired
    private ISongService songService;

    private final String UPLOAD_DIR = "D:/module04/audio/";

    @GetMapping
    public ModelAndView listSongs() {
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("songs", songService.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("songForm", new SongForm());
        return modelAndView;
    }

    @PostMapping("/save")
    public String saveSong(@ModelAttribute SongForm songForm) {
        MultipartFile multipartFile = songForm.getFile();
        String fileName = multipartFile.getOriginalFilename();
        try {
            File dest = new File(UPLOAD_DIR + fileName);
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();
            }
            multipartFile.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Song song = new Song(songForm.getName(), songForm.getArtist(), songForm.getGenre(), fileName);
        songService.save(song);
        return "redirect:/songs";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Optional<Song> songOptional = songService.findById(id);
        if (songOptional.isPresent()) {
            Song song = songOptional.get();
            SongForm songForm = new SongForm(song.getId(), song.getName(), song.getArtist(), song.getGenre(), null);
            ModelAndView modelAndView = new ModelAndView("edit");
            modelAndView.addObject("songForm", songForm);
            modelAndView.addObject("currentFile", song.getFilePath());
            return modelAndView;
        }
        return new ModelAndView("redirect:/songs");
    }

    @PostMapping("/update")
    public String updateSong(@ModelAttribute SongForm songForm) {
        Optional<Song> songOptional = songService.findById(songForm.getId());
        if (songOptional.isPresent()) {
            Song song = songOptional.get();
            song.setName(songForm.getName());
            song.setArtist(songForm.getArtist());
            song.setGenre(songForm.getGenre());

            MultipartFile multipartFile = songForm.getFile();
            // CHỖ NÀY ĐÃ SỬA: Chỉ cập nhật file nếu người dùng chọn file mới
            if (multipartFile != null && multipartFile.getSize() > 0) {
                String fileName = multipartFile.getOriginalFilename();
                try {
                    File dest = new File(UPLOAD_DIR + fileName);
                    multipartFile.transferTo(dest);
                    song.setFilePath(fileName);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            songService.save(song);
        }
        return "redirect:/songs";
    }

    @GetMapping("/delete/{id}")
    public String deleteSong(@PathVariable Long id) {
        songService.delete(id);
        return "redirect:/songs";
    }
}