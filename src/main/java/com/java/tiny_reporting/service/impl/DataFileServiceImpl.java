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
     * 准备一个文件
     *
     * @param totalCount 数据量总条数
     */
    @Override
    public void prepareFileData(Integer totalCount) {

        try {
            // 1. 模拟生成数据文件
            FileGenerator.createAll("", totalCount);
        } catch (Exception e) {
            LogUtil.error(LOGGER, e, "准备文件出现错误,条数{1}", totalCount);
        }

    }
}