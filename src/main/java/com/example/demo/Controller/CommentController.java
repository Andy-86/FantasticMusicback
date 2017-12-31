package com.example.demo.Controller;

import com.example.demo.Reprository.CommentRepository;
import com.example.demo.Reprository.SongRepository;
import com.example.demo.annotation.CurrentUser;
import com.example.demo.annotation.LoginRequired;
import com.example.demo.bean.Comment;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by andy on 2017/11/20.
 */
@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentRepository commentRepository;

    @LoginRequired
    @PostMapping("/add")
    public Comment add(@CurrentUser User user,@RequestParam("songId")Integer songId, @RequestParam("content")String content){
        Comment comment=new Comment();
        comment.setSongId(songId);
        comment.setContent(content);
        comment.setUserId(user.getId());
        comment.setData(System.currentTimeMillis());
        return commentRepository.save(comment);
    }
    @LoginRequired
    @GetMapping("/findbyuserid")
    public List<Comment> findByUserId(@CurrentUser User user){
        return commentRepository.findByUserId(user.getId());
    }

    @LoginRequired
    @PostMapping("/findbysongid")
    public List<Comment> findBySongId(@CurrentUser User user,@RequestParam("songid")Integer songId){
        return commentRepository.findBySongId(songId);
    }

}
