package com.wuyan.masteryi.admin.controller;

import com.wuyan.masteryi.admin.entity.User;
import com.wuyan.masteryi.admin.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Author: Zhao Shuqing
 * @Date: 2021/7/7 14:32
 * @Description:
 */

@RestController
@RequestMapping("/user")
@Api(tags ="用户管理接口")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/getalluser")
    @ApiOperation(value="获取全部用户信息", notes="获取全部用户信息")
    public Map<String,Object> getAllUser(){
        return userService.getAllUser();
    }

    @PostMapping("/adduser")
    @ApiOperation(value="添加用户", notes="添加用户")
    public Map<String,Object> addUser(String userName, String userPwd, String userImgUrl, String address, String phoneNum){
        return userService.addUser(userName, userPwd, userImgUrl, address, phoneNum);
    }

    @PostMapping("/deleteuser")
    @ApiOperation(value="删除所选用户", notes="删除所选用户")
    public Map<String,Object> deleteUser(Integer[] userIds){
        return userService.deleteUser(userIds);
    }

    @PostMapping("/changeuser")
    @ApiOperation(value="更改用户信息", notes="更改用户信息")
    public Map<String,Object> changeUser(User user){
        return userService.changeUser(user);
    }
}
