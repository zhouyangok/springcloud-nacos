package com.mongodb.mapper;

import com.mongodb.entity.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @ClassName CommentRepository
 * @Description: TODO
 * @Author zhouyang
 * @Date 2020/12/30 下午6:07.
 */

public interface CommentRepository extends MongoRepository<Comment,String > {
}
