/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.java.tiny_reporting.utils;

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

}
