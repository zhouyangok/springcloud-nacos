package com.mongodb.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @ClassName Commnet
 * @Description: 评论
 * @Author zhouyang
 * @Date 2020/12/30 下午5:59.
 */
@Data
@Document("comment")
public class Comment implements Serializable {
    @Id
    private String id;
    @Field("content")
    private String content;
    private Date publishDate;
    @Indexed
    private String userId;
    private String nickName;
    private LocalDateTime createDateTime;
    private Integer likenum;
    private Integer replynum;
    private String state;
    private String parentId;
    private String articleId;

}
