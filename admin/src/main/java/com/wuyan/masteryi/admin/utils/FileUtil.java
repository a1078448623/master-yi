package com.wuyan.masteryi.admin.utils;
/*
 *project:master-yi
 *file:FileUtil
 *@author:wsn
 *date:2021/7/15 10:10
 */

public class FileUtil {
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
