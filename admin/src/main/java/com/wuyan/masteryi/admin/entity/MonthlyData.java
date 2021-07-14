package com.wuyan.masteryi.admin.entity;
/*
 *project:master-yi
 *file:MonthlyData
 *@author:wsn
 *date:2021/7/12 9:43
 */

import lombok.Data;

import java.util.Date;

@Data
public class MonthlyData {
    private String createMonth;
    private int count;
    private int sales;

}
