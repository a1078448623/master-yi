package com.wuyan.masteryi.admin.entity;

import lombok.Data;

/**
 * @Author: Zhao Shuqing
 * @Date: 2021/7/6 10:30
 * @Description:
 */

@Data
public class User {
    private Integer userId;
    private String userName;
    private String userPwd;
    private String userImgUrl;
    private String address;
    private String phoneNum;
    private float lowPrice;
}
