/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.java.tiny_reporting.service;

/**
 * @author qinjiasui.qjs
 * @version ZipService: ZipService.java, v 0.1 2021年05月17日 下午2:45 qinjiasui.qjs Exp $
 */
public interface ZipService {

    /**
     * 串行打包文件
     * @param srcFileDir 源文件dir
     * @param destFileDir 打包后文件储存dir
     */
    void serialZip(String srcFileDir, String destFileDir);

    /**
     * 并行打包文件
     * @param srcFileDir 源文件dir
     * @param destFileDir 打包后文件储存dir
     */
    void parallelZip(String srcFileDir, String destFileDir);
}