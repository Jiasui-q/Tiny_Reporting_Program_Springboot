/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.java.tiny_reporting.service.impl;

import com.java.tiny_reporting.service.LogService;
import com.java.tiny_reporting.utils.LogGenerator;
import com.java.tiny_reporting.utils.logger.LogUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author qinjiasui.qjs
 * @version LogServiceImpl: LogServiceImpl.java, v 0.1 2021年05月17日 下午2:43 qinjiasui.qjs Exp $
 */
@Service
public class LogServiceImpl implements LogService {

    /**
     * LOGGER
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(LogService.class);

    /**
     * 为传入文件生成log文件
     *
     * @param srcFilePath 源文件路径名
     */
    @Override
    public void prepareLogFile(String srcFilePath){
        try {
            LogGenerator.generateLogFile(srcFilePath);
        } catch (Throwable e) {
            LogUtil.error(LOGGER, e, "准备log文件出现错误,源文件{1}", srcFilePath);
        }
    }

    /**
     * 为srcFileDir下所有文件生成log文件
     *
     * @param srcFileDir 源文件dir
     */
    @Override
    public void prepareLogFileFromDir(String srcFileDir) {
        File files = new File(srcFileDir);
        ExecutorService es = Executors.newFixedThreadPool(10);
        for (File file : files.listFiles()) {
            Runnable task = () -> {
                try {
                    LogGenerator.generateLogFile(file.getAbsolutePath());
                } catch (Throwable e) {
                    LogUtil.error(LOGGER, e, "准备log文件出现错误,源文件{1}", file.getAbsolutePath());
                }
            };
            es.submit(task);
        }
    }
}
