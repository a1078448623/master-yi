package com.wuyan.masteryi.mall.entity;
/*
 *project:master-yi
 *file:Comment
 *@author:wsn
 *date:2021/7/13 14:29
 */

import lombok.Data;

import java.util.Date;
import java.util.Map;

@Data
public class Comment {
    private int commentId;
    private int toGoodId;
    private int reUserId;
    private int replyId;
    private int likes;
    private int stars;
    private int inOrderId;
    private String userName;
    private String userImg;
    private Date comTime;
    private String content;
    private String fTime;
    private Map<String,String> description;
}
