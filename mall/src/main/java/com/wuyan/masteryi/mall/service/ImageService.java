package com.wuyan.masteryi.mall.service;
/*
 *project:master-yi
 *file:ImageService
 *@author:wsn
 *date:2021/7/14 11:00
 */

import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface ImageService {

    Map<String,Object> saveImage(MultipartFile file,int u_id);
}
