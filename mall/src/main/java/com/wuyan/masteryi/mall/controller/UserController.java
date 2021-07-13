package com.wuyan.masteryi.mall.controller;
/*
 *project:master-yi
 *file:UserController
 *@author:wsn
 *date:2021/7/6 14:32
 */

import com.wuyan.masteryi.mall.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/user")
@Api(tags = "用户接口")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/queryUser")
    @ApiOperation(value = "查找用户",notes = "通过用户名和密码查找用户")
    public Map<String, Object> getUserByNP(String username, String password){
        return userService.getUserByNP(username,password);
    }

    @PostMapping("/addUser")
    @ApiOperation(value = "添加用户",notes = "添加用户")
    public Map<String, Object> addUser(String username, String password) {
        return userService.addUser(username,password);
    }

    @PostMapping("/setAddr")
    @ApiOperation(value = "设置地址",notes = "设置地址")
    public Map<String, Object> setAddr(int u_id, String address){
        return userService.setAddr(u_id,address);
    }

    @PostMapping("/setPhone")
    @ApiOperation(value = "设置手机号",notes = "设置手机号")
    public Map<String, Object> setPhoneNum(int u_id, String phoneNum) {
        return userService.setPhoneNum(u_id,phoneNum);
    }

    @PostMapping("/setImg")
    @ApiOperation(value = "设置头像",notes = "设置头像")
    public Map<String, Object> setImg(int u_id, String imgurl){
        return userService.setImg(u_id,imgurl);
    }
    @PostMapping("/isNameRep")
    @ApiOperation(value = "用户名是否重复",notes = "检测用户名是否重复")
    public Map<String, Object> isNameRep(String username){
        return userService.isNameRep(username);
    }
    @PostMapping("/isPhoneRep")
    @ApiOperation(value = "手机号是否重复",notes = "检测手机号是否重复")
    public Map<String, Object> isPhoneRep(String phoneNum){
        return userService.isPhoneRep(phoneNum);
    }

    @PostMapping("/getuser")
    @ApiOperation(value = "获取用户信息",notes = "获取用户信息")
    public Map<String, Object> getUser(Integer userId){
        return userService.getUser(userId);
    }

    @PostMapping("/changeuserinfo")
    @ApiOperation(value = "获取用户信息",notes = "获取用户信息")
    public Map<String, Object> changeUserInfo(Integer userId,String userName,String userPwd,String phoneNum,String userAddress, String userImgUrl){
        return userService.changeUserInfo(userId,userName,userPwd,phoneNum,userAddress,userImgUrl);
    }
}
