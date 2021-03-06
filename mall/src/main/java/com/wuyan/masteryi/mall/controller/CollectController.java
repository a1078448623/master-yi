package com.wuyan.masteryi.mall.controller;

import com.wuyan.masteryi.mall.service.CollectService;
import com.wuyan.masteryi.mall.service.GetUidServerImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Author: Zhao Shuqing
 * @Date: 2021/7/6 16:30
 * @Description:
 */

@Api(tags="收藏接口")
@RestController
@RequestMapping("/collect")
public class CollectController {

    @Autowired
    CollectService collectService;

    @Autowired
    GetUidServerImpl getUidServer;

    @ApiOperation(value="添加到收藏夹", notes="添加到收藏夹")
    @PostMapping("/addtocollect")
    public Map<String, Object> addToCollect(@RequestHeader("token")String token, Integer goodsId){
        return collectService.addToCollect(getUidServer.getIntegerUid(token), goodsId);
    }

    @ApiOperation(value="从收藏夹删除", notes="从收藏夹删除")
    @PostMapping("/deletefromcollect")
    public Map<String, Object> deleteFromCollect(Integer collectId){
        return collectService.deleteFromCollect(collectId);
    }

    @ApiOperation(value="获取收藏夹", notes="获取收藏夹")
    @PostMapping("/showmycollect")
    public Map<String, Object> showMyCollect(@RequestHeader("token")String token){
        return collectService.showMyCollect(getUidServer.getIntegerUid(token));
    }

    @ApiOperation(value="获取收藏状态", notes="获取收藏状态")
    @PostMapping("/iscollect")
    public Map<String, Object> isCollect(@RequestHeader("token")String token,Integer specId){
        return collectService.isCollect(getUidServer.getintUid(token),specId);
    }
}
