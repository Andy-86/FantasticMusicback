package com.example.demo.Controller;

import com.example.demo.Reprository.SongRepository;
import com.example.demo.bean.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by andy on 2017/9/27.
 */
@RestController
public class SongController {
    @Autowired
    private SongRepository songRepository;

    /**
     * 获取歌曲列表
     * @return
     */
    @GetMapping(value = "/songs")
    public List<Song> getSongs(){
        return songRepository.findAll();
    }
}
