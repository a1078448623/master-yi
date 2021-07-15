package com.wuyan.masteryi.mall.utils;
/*
 *project:master-yi
 *file:FileUtil
 *@author:wsn
 *date:2021/7/14 10:59
 */

public class FileUtil {
    // 图片允许的后缀扩展名
    public static String[] IMAGE_FILE_EXTD = new String[] { "png", "bmp", "jpg", "jpeg","pdf" };

    public static boolean isFileAllowed(String fileName) {
        for (String ext : IMAGE_FILE_EXTD) {
            if (ext.equals(fileName)) {
                return true;
            }
        }
        return false;
    }

}
