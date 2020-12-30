package com.mongodb.service;

import com.mongodb.entity.Comment;
import com.mongodb.mapper.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName CommentService
 * @Description: 评论服务层
 * @Author zhouyang
 * @Date 2020/12/30 下午6:08.
 */
@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    /**
     * 保存评论
     * @param comment
     */
    public void saveComment(Comment comment){
        commentRepository.save(comment);
    }

    /**
     * 更新评论
     * @param comment
     */
    public void updateComment(Comment comment){
        commentRepository.save(comment);
    }

    /**
     * 删除评论
     * @param id
     */
    public void deleteCommentById(String id){
        commentRepository.deleteById(id);
    }

    /**
     * 获取评论列表
     * @return
     */
    public List<Comment> findCommentList(){
        return commentRepository.findAll();
    }

    /**
     * 根据id获取评论
     * @param id
     * @return
     */
    public Comment findCommentById(String id){
        return commentRepository.findById(id).get();
    }
}
