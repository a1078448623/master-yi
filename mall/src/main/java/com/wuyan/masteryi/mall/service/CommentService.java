package com.wuyan.masteryi.mall.service;
/*
 *project:master-yi
 *file:CommentService
 *@author:wsn
 *date:2021/7/13 14:32
 */

import com.wuyan.masteryi.mall.entity.Comment;

import java.util.List;
import java.util.Map;

public interface CommentService {
    Map<String,Object> getCommentsByGoodId(int goodId);
    Map<String,Object> addComment(int goodId,int userId,String content,int stars,int orderId);
    Map<String,Object> addReply(int goodId,int userId,String content,int toComId);
    Map<String,Object> getCommentsByComId(int comId);
}
