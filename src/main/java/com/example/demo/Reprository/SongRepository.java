package com.example.demo.Reprository;

import com.example.demo.bean.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by andy on 2017/9/27.
 */
@Repository
public interface SongRepository extends JpaRepository<Song,Integer> {
    public List<Song> findBySongid(Integer songid);
}
