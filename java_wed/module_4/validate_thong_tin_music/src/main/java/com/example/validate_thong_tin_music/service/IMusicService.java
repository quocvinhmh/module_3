package com.example.validate_thong_tin_music.service;

import com.example.validate_thong_tin_music.model.Music;

import java.util.List;

public interface IMusicService {
    void save (Music music);
    List<Music> getMusic();
    void update (int id,Music music);
    Music getMusicById(int id);
}
