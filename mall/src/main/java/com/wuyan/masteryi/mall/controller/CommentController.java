package com.wuyan.masteryi.mall.controller;
/*
 *project:master-yi
 *file:CommentController
 *@author:wsn
 *date:2021/7/13 14:29
 */

import com.wuyan.masteryi.mall.service.CommentService;
import com.wuyan.masteryi.mall.service.GetUidServerImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@Api(tags = "评论接口")
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    CommentService commentService;

    @Autowired
    GetUidServerImpl getUidServer;

    @PostMapping("/comsbygoodid")
    @ApiOperation(value = "根据商品id获取评论",notes = "根据商品id获取评论")
    Map<String,Object> getCommentsByGoodId(int goodId){
        return commentService.getCommentsByGoodId(goodId);
    }

    @PostMapping("/replysbycomid")
    @ApiOperation(value = "根据评论id获取回复",notes = "根据评论id获取回复")
    Map<String,Object> getCommentsByComId(int comId){
        return commentService.getCommentsByComId(comId);
    }
    @PostMapping("/addcomment")
    @ApiOperation(value = "添加评论",notes = "添加评论")
    Map<String,Object> addComment(int goodId,@RequestHeader("token")String token,String content,int stars,int orderId){
        return commentService.addComment(goodId,getUidServer.getintUid(token),content,stars,orderId);
    }
    @PostMapping("/addreply")
    @ApiOperation(value = "添加回复",notes = "添加回复")
    Map<String,Object> addReply(int goodId, @RequestHeader("token")String token, String content, int toComId){
        return commentService.addReply(goodId,getUidServer.getintUid(token),content,toComId);
    }
}
