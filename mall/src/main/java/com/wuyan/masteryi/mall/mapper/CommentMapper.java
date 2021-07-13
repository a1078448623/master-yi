package com.wuyan.masteryi.mall.mapper;
/*
 *project:master-yi
 *file:CommentMapper
 *@author:wsn
 *date:2021/7/13 14:31
 */

import com.wuyan.masteryi.mall.entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface CommentMapper {
    List<Comment> getCommentsByGoodId(int goodId);
    void addComment(int goodId,int userId,String content,int stars,int orderId);
    void addReply(int goodId,int userId,String content,int toComId);
    List<Comment> getCommentsByComId(int comId);
    List<Integer> getSpecIdByCom(int orderId,int goodId);
    Map<String,String> getComUserMsg(int userId);
}
