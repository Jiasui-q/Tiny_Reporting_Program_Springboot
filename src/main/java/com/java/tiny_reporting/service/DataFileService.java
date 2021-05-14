/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.java.tiny_reporting.service;

public interface DataFileService {

    /**
     * 准备一个文件
     *
     * @param fileName 文件名
     * @param totalCount 数据量总条数
     */
    void prepareWholeFile(String fileName, Integer totalCount);

    /**
     * 将文件拆分
     *
     * @param fileName 文件名
     * @param groupCount 分组数量
     */
    void prepareSplitFile(String fileName, Integer groupCount);

    /**
     * 生成log文件
     *
     * @param fileName 文件名
     */
    void prepareLogFile(String fileName);

    /**
     * 并行打包文件
     */
    void serialZip();

    /**
     * 串行打包文件
     */
    void parallelZip();
}