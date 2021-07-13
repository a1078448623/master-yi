package com.wuyan.masteryi.mall.service;
/*
 *project:master-yi
 *file:CommentServiceImpl
 *@author:wsn
 *date:2021/7/13 14:32
 */

import com.wuyan.masteryi.mall.entity.Comment;
import com.wuyan.masteryi.mall.mapper.CommentMapper;
import com.wuyan.masteryi.mall.utils.ResponseMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    CommentMapper commentMapper;
    @Autowired
    GoodsService goodsService;

    @Override
    public Map<String, Object> getCommentsByGoodId(int goodId) {
        List<Comment> commentsByGoodId = commentMapper.getCommentsByGoodId(goodId);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy MM dd hh:mm");

        for(Comment comment:commentsByGoodId){
            List<Integer> specIdByCom = commentMapper.getSpecIdByCom(comment.getInOrderId(), goodId);
            Map<String, String> comUserMsg = commentMapper.getComUserMsg(comment.getReUserId());
            comment.setUserImg(comUserMsg.get("user_img_url"));
            comment.setUserName(comUserMsg.get("user_name"));
            if(specIdByCom.size()>0){
                comment.setDescription((Map<String, String>) goodsService.getSpecsDesc(specIdByCom.get(0)).get("data"));
            }
            comment.setFTime(sdf.format(comment.getComTime()));
        }
        return ResponseMsg.sendMsg(200,"ok",commentsByGoodId);
    }

    @Override
    public Map<String, Object> addComment(int goodId, int userId, String content, int stars,int orderId) {
        commentMapper.addComment(goodId,userId,content,stars,orderId);

        return ResponseMsg.sendMsg(200,"ok",null);
    }

    @Override
    public Map<String, Object> addReply(int goodId, int userId, String content, int toComId) {
        commentMapper.addReply(goodId,userId,content,toComId);
        return ResponseMsg.sendMsg(200,"ok",null);
    }

    @Override
    public Map<String, Object> getCommentsByComId(int comId) {
        List<Comment> commentsByComId = commentMapper.getCommentsByComId(comId);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy MM dd hh:mm");
        for(Comment comment:commentsByComId){
            Map<String, String> comUserMsg = commentMapper.getComUserMsg(comment.getReUserId());
            comment.setUserImg(comUserMsg.get("user_img_url"));
            comment.setUserName(comUserMsg.get("user_name"));
            comment.setFTime(sdf.format(comment.getComTime()));
        }
        return ResponseMsg.sendMsg(200,"ok",commentsByComId);
    }
}
