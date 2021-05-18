/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.java.tiny_reporting.service.impl;

import com.java.tiny_reporting.service.DataFileService;
import com.java.tiny_reporting.utils.FileGenerator;
import com.java.tiny_reporting.utils.logger.LogUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DataFileServiceImpl implements DataFileService {

    /**
     * LOGGER
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(DataFileService.class);

    /**
     * 生成指定个随机RandomPerson并写入文件
     *
     * @param destFilePath 生成文件储存路径
     * @param totalCount 数据量总条数
     */
    @Override
    public void prepareWholeFile(String destFilePath, int totalCount) {
        try {
            FileGenerator.createWholeFile(destFilePath, totalCount);
            System.out.println("文件生成\r\n");
        } catch (Throwable e) {
            LogUtil.error(LOGGER, e, "准备文件出现错误, 总条数{0}", totalCount);
        }
    }

    /**
     * 将文件拆分为最多指定条数
     *
     * @param srcFilePath 源文件路径
     * @param destFileDir 拆分文件储存dir
     * @param fileName 拆分文件名
     * @param eachFileCount 各拆分文件最多条数
     */
    @Override
    public void splitFile(String srcFilePath, String destFileDir, String fileName, int eachFileCount) {
        try {
            FileGenerator.splitFile(srcFilePath, destFileDir, fileName, eachFileCount);
        } catch (Throwable e) {
            LogUtil.error(LOGGER, e, "拆分文件出现错误, 每个文件条数{0}", eachFileCount);
        }
    }

    /**
     * 按RandomPerson年龄将文件拆分
     *
     * @param srcFilePath 源文件路径
     * @param destFileDir 拆分文件储存dir
     * @param fileName 拆分文件名
     * @param groupCount 分组数
     */
    @Override
    public void splitFileOnAge(String srcFilePath, String destFileDir, String fileName, int groupCount) {
        try {
            FileGenerator.splitFileOnAge(srcFilePath, destFileDir, fileName, groupCount);
        } catch (Throwable e) {
            LogUtil.error(LOGGER, e, "根据年龄拆分文件出现错误, 组数{0}", groupCount);
        }
    }
}