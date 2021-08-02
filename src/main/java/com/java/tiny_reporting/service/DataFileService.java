/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.java.tiny_reporting.service;

public interface DataFileService {

    /**
     * 生成指定个随机RandomPerson并写入filePath
     *  @param destFileDir 生成文件储存Dir
     * @param fileName 生成文件名
     * @param totalCount 数据总条数
     */
    void prepareWholeFile(String destFileDir, String fileName, int totalCount);

    /**
     * 将文件拆分为最多指定条数
     *
     * @param srcFilePath 源文件路径
     * @param destFileDir 拆分文件储寸dir
     * @param fileName 拆分文件名
     * @param eachFileCount 各拆分文件最多条数
     */
    void splitFile(String srcFilePath, String destFileDir, String fileName, int eachFileCount);

    /**
     * 按RandomPerson年龄将文件拆分
     *
     * @param srcFilePath 源文件路径
     * @param destFileDir 拆分文件储存dir
     * @param fileName 拆分文件名
     * @param groupCount 分组数
     */
    void splitFileOnAge(String srcFilePath, String destFileDir, String fileName, int groupCount);
}