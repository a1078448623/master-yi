package com.wuyan.masteryi.admin.entity;
/*
 *project:master-yi
 *file:UserCount
 *@author:wsn
 *date:2021/7/12 13:10
 */

import lombok.Data;

import java.util.Date;

@Data
public class UserCateCount {
    private Date time;
    private int count;
    private String f_time;
    private String categoryName;
    private int sales;
}
