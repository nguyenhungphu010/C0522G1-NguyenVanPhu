package com.service.impl;

import com.model.SongInfor;
import com.repository.ISongRepository;
import com.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService implements ISongService {

    @Autowired
    private ISongRepository iSongRepository;
    @Override
    public List<SongInfor> listAll() {
        return iSongRepository.findAll();
    }

    @Override
    public void create(SongInfor songInfor) {
        iSongRepository.save(songInfor);
    }

    @Override
    public void update(SongInfor songInfor) {
        iSongRepository.save(songInfor);
    }

    @Override
    public SongInfor findById(int id) {
        return  iSongRepository.findById(id).orElse(new SongInfor());
    }
}
