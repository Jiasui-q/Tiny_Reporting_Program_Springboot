/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.java.tiny_reporting.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import org.joda.time.DateTime;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author qinjiasui.qjs
 * @version DateUtil: DateUtil.java, v 0.1 2021年05月19日 4:26 下午 qinjiasui.qjs Exp $
 */
public class DateUtil {

    /**
     * 获取当前时间
     *
     * @return
     */
    public static Date getNow() {
        return DateTime.now().toDate();
    }

    /**
     * 返回目前时间的GMT形式
     * @return String
     */
    public static String getGMTDate(){
        SimpleDateFormat dateFormatGmt = new SimpleDateFormat("dd:MM:yyyy HH:mm:ss");
        dateFormatGmt.setTimeZone(TimeZone.getTimeZone("GMT"));
        return dateFormatGmt.format(new Date());
    }

    public static void main(String[] args){
        try {
            File dir = new File("flow1/original");
            System.out.println(dir.exists());
            if (!dir.exists()) {
                dir.mkdirs();
            }
            System.out.println(dir.exists());
            File dir2 = new File("flow1/haha");
            System.out.println(dir2.exists());
            if (!dir2.exists()) {
                dir2.mkdirs();
            }
            System.out.println(dir2.exists());
            //File file = new File("flow1/original/demo1.txt");
            //file.createNewFile();
            //System.out.println(file.exists());
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}
