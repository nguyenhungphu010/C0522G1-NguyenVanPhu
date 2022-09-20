package com.repository;

import com.model.SongInfor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISongRepository extends JpaRepository<SongInfor, Integer> {

}
