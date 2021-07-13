package com.wuyan.masteryi.admin.utils;
/*
 *project:master-yi
 *file:OrderStatu
 *@author:wsn
 *date:2021/7/12 15:01
 */

public class OrderStatu {

    public static String getStatu(int statuId){
        switch (statuId){
            case 1:return "尚未支付";
            case 2:return "运输中";
            case 3:return "已完成";
            case 4:return "请求退款";
            case 5:return "失效订单";
            case 6:return "已退款";
        }
        //1 表示订单已创建但还未支付
        //2 表示订单已支付，正在运输中
        //3 表示运输完成，订单完成
        //4 表示请求退款
        //5 支付失败或超时，等待删除
        //6 退款成功
        return "error";
    }
}
