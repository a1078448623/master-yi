package com.wuyan.masteryi.mall.controller;

import com.wuyan.masteryi.mall.mapper.UserMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
@Api(tags = "注册接口")
public class RegisterController {
    @Autowired
    UserMapper userMapper;

    @PostMapping("/comfirm")
    @ResponseBody
    @ApiOperation(value = "注册测试",notes = "注册测试")
    public int register (String userName, String password){
        return userMapper.addUser(userName, password);
    }


}
