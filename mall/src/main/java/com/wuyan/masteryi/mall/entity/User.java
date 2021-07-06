package com.wuyan.masteryi.mall.entity;

import lombok.Data;

@Data
public class User {
    private Integer userId;
    private String userName;
    private String userPwd;
    private String userImgUrl;
    private String address;
}
