package com.wuyan.masteryi.admin.service;
/*
 *project:master-yi
 *file:ImageService
 *@author:wsn
 *date:2021/7/15 9:19
 */

import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface ImageService {

    Map<String,Object> saveImage(MultipartFile file,int goodId);
    Map<String,Object> saveSpecImage(MultipartFile file,int id);
}
