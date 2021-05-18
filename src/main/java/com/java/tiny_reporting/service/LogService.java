/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.java.tiny_reporting.service;

/**
 * @author qinjiasui.qjs
 * @version LogFileService: LogFileService.java, v 0.1 2021年05月17日 下午1:58 qinjiasui.qjs Exp $
 */
public interface LogService {
    /**
     * 为传入文件生成log文件
     *
     * @param srcFilePath 源文件路径名
     * @param destFileDir log文件储存dir
     */
    void prepareLogFile(String srcFilePath, String destFileDir);

    /**
     * 为srcFileDir下所有文件生成log文件
     *
     * @param srcFileDir 源文件dir
     * @param destFileDir log文件储存dir
     */
    void prepareLogFileFromDir(String srcFileDir, String destFileDir);
}