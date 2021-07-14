package com.wuyan.masteryi.admin.entity;
/*
 *project:master-yi
 *file:OrderCount
 *@author:wsn
 *date:2021/7/11 20:48
 */

import lombok.Data;

import java.util.Date;

@Data
public class OrderCount {
    private Date date;
    private int count;
    private float totalMoney;
    private String f_date;
}
