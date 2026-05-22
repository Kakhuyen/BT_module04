package com.codegym.musicuploaddemo.service;

import com.codegym.musicuploaddemo.model.Song;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SongService {

    private final List<Song> songs = new ArrayList<>();

    public List<Song> findAll() {
        return songs;
    }

    public void save(Song song) {
        songs.add(song);
    }
}