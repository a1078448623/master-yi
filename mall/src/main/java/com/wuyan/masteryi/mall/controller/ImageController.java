package com.wuyan.masteryi.mall.controller;

import com.wuyan.masteryi.mall.service.GetUidServerImpl;
import com.wuyan.masteryi.mall.service.ImageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/*
 *project:master-yi
 *file:ImageController
 *@author:wsn
 *date:2021/7/14 21:34
 */
@RestController
@RequestMapping("/image")
@Api(tags = "上传图片")
public class ImageController {

    @Autowired
    ImageService imageService;

    @Autowired
    GetUidServerImpl getUidServer;

    @PostMapping("/upload")
    @ApiOperation(value = "上传图片",notes = "上传图片")
    public Map<String,Object> saveImage(MultipartFile file,@RequestHeader("token")String token){
        return imageService.saveImage(file,getUidServer.getintUid(token));
    }
}
