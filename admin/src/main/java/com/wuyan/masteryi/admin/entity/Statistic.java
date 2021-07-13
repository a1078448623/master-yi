package com.wuyan.masteryi.admin.entity;
/*
 *project:master-yi
 *file:Stastistic
 *@author:wsn
 *date:2021/7/11 16:16
 */

import lombok.Data;

@Data
public class Statistic {
    private int sales;
    float earnings;
    private int visitors;
    private int users;
    private int orders;

    public Statistic(int sales, float earnings, int visitors, int users, int orders) {
        this.sales = sales;
        this.earnings = earnings;
        this.visitors = visitors;
        this.users = users;
        this.orders = orders;
    }
}
