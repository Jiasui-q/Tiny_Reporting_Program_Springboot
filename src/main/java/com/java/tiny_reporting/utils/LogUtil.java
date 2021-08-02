/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.java.tiny_reporting.utils;

import java.text.MessageFormat;

import org.slf4j.Logger;

public class LogUtil {

    /**
     * 生成<font color="brown">异常</font>级别日志<br>
     * 可输出异常堆栈
     * 可处理任意多个输入参数，并避免在日志级别不够时字符串拼接带来的资源浪费
     *
     * @param logger
     * @param obj
     */
    public static void error(Logger logger, String template, Object... obj) {
        logger.error(getMessage(template, obj));
    }

    /**
     * 生成<font color="brown">异常</font>级别日志<br>
     * 可输出异常堆栈
     * 可处理任意多个输入参数，并避免在日志级别不够时字符串拼接带来的资源浪费
     *
     * @param logger
     * @param t
     * @param obj
     */
    public static void error(Logger logger, Throwable t, String template, Object... obj) {
        logger.error(getMessage(template, obj), t);
    }

    /**
     * 计算带TraceId的日志信息。<BR>
     *
     * @param template
     * @param parameters
     * @return
     */
    private static String getMessage(String template, Object... parameters) {

        try {
            if (parameters.length == 0) {
                return template;
            }
            return MessageFormat.format(template, parameters);
        } catch (Exception e) {
            return template + "[日志打印工具类异常]：" + e.getMessage();
        }

    }
}