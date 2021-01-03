package com.mongodb.controller;

import com.mongodb.entity.Comment;
import com.mongodb.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName CommentController
 * @Description: TODO
 * @Author zhouyang
 * @Date 2021/1/3 下午8:19.
 */
@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    /**
     * 保存评论
     * @param comment
     */
    @PostMapping("/saveComment")
    public void saveComment(@RequestBody Comment comment){
        commentService.saveComment(comment);
    }
}
