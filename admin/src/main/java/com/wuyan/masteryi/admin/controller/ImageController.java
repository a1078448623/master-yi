package com.wuyan.masteryi.admin.controller;
/*
 *project:master-yi
 *file:ImageController
 *@author:wsn
 *date:2021/7/15 9:35
 */

import com.wuyan.masteryi.admin.service.ImageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@RequestMapping("/image")
@Api(tags = "上传图片")
public class ImageController {

    @Autowired
    ImageService imageService;


    @PostMapping("/upload/{goodId}")
    @ApiOperation(value = "上传图片",notes = "上传图片")
    public Map<String,Object> saveImage(MultipartFile file,@PathVariable String goodId){
        return imageService.saveImage(file,Integer.parseInt(goodId));
    }
    @PostMapping("/upspecload/{id}")
    @ApiOperation(value = "上传特定规格图片",notes = "上传图片")
    public Map<String,Object> saveSpecImage(MultipartFile file,@PathVariable String id){
        return imageService.saveSpecImage(file,Integer.parseInt(id));
    }
}
