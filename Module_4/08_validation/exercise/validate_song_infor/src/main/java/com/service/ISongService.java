package com.service;

import com.model.SongInfor;

import java.util.List;

public interface ISongService {
    List<SongInfor> listAll();
    void create(SongInfor songInfor);
    void update(SongInfor songInfor);
    SongInfor findById(int id);
}
