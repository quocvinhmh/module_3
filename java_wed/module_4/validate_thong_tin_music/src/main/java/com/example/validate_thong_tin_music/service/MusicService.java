package com.example.validate_thong_tin_music.service;

import com.example.validate_thong_tin_music.model.Music;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class MusicService implements IMusicService {
private  static  List<Music> musicList = new ArrayList<>();
    @Override
    public void save(Music music) {
        musicList.add(music);
    }

    @Override
    public List<Music> getMusic() {
        return musicList;
    }

    @Override
    public void update(int id, Music music) {
        musicList.set(id, music);
    }

    @Override
    public Music getMusicById(int id) {
        return musicList.get(id);
    }
}
