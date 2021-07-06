package com.wuyan.masteryi.mall.controller;

import com.wuyan.masteryi.mall.service.CollectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Author: Zhao Shuqing
 * @Date: 2021/7/6 16:30
 * @Description:
 */

@Api("collect")
@RestController
@RequestMapping("/collect")
public class CollectController {

    @Autowired
    CollectService collectService;

    @ApiOperation(value="添加到收藏夹", notes="添加到收藏夹")
    @PostMapping("/addtocollect")
    public Map<String, Object> addToCollect(Integer userId, Integer goodsId){
        return collectService.addToCollect(userId, goodsId);
    }

    @ApiOperation(value="从收藏夹删除", notes="从收藏夹删除")
    @PostMapping("/deletefromcollect")
    public Map<String, Object> deleteFromCollect(Integer collectId){
        return collectService.deleteFromCollect(collectId);
    }

}
