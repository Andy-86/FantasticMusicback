package com.example.demo.Reprository;

import com.example.demo.bean.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by andy on 2017/11/20.
 */
@Repository
public interface CommentRepository extends JpaRepository<Comment,Integer> {
    //通过songId来查找评论
    public List<Comment> findBySongId(Integer songId);
    public List<Comment> findByUserId(Integer userId);
}
