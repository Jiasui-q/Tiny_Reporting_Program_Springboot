/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.java.tiny_reporting.service.impl;

import java.io.IOException;

import com.java.tiny_reporting.service.DataFileService;
import com.java.tiny_reporting.utils.FileGenerator;
import com.java.tiny_reporting.utils.LogGenerator;
import com.java.tiny_reporting.utils.ZipGenerator;
import com.java.tiny_reporting.utils.logger.LogUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author jinyu.qjy
 * @version $Id: DataFileServiceImpl.java, v 0.1 2021年05月11日 9:55 AM jinyu.qjy Exp $
 */
@Service
public class DataFileServiceImpl implements DataFileService {

    /**
     * LOGGER
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(DataFileService.class);

    /**
     * 生成文件储存路径
     */
    private final String PATH = "src/data/original/";

    /**
     * 准备一个文件并生成指定条随机数据
     *
     * @param fileName 文件名
     * @param totalCount 数据量总条数
     */
    @Override
    public void prepareWholeFile(String fileName, Integer totalCount) {
        try {
            FileGenerator.createWholeFile(PATH + fileName, totalCount);
        } catch (Throwable e) {
            LogUtil.error(LOGGER, e, "准备文件出现错误,条数{1}", totalCount);
        }
    }

    /**
     * 将文件拆分
     *
     * @param fileName 文件名
     * @param groupCount 分组数量
     */
    @Override
    public void prepareSplitFile(String fileName, Integer groupCount) {
        try {
            FileGenerator.createSplitFile(PATH + fileName, groupCount);
        } catch (Throwable e) {
            LogUtil.error(LOGGER, e, "准备文件出现错误,条数{1}", groupCount);
        }
    }

    /**
     * 生成log文件
     *
     * @param fileName 文件名
     */
    @Override
    public void prepareLogFile(String fileName){
        try {
            LogGenerator.generateLogFile(PATH + fileName);
        } catch (Throwable e) {
            LogUtil.error(LOGGER, e, "准备文件出现错误,条数{1}");
        }
    }

    /**
     * 并行打包文件
     */
    @Override
    public void serialZip(){
        try {
            ZipGenerator.serialZip(PATH);
        } catch (Throwable e) {
            LogUtil.error(LOGGER, e, "准备文件出现错误,条数{1}");
        }
    }

    /**
     * 串行打包文件
     */
    @Override
    public void parallelZip(){
        try {
            ZipGenerator.parallelZip(PATH);
        } catch (Throwable e) {
            LogUtil.error(LOGGER, e, "准备文件出现错误,条数{1}");
        }
    }
}