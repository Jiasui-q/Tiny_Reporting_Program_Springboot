/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.java.tiny_reporting.service.impl;

import com.java.tiny_reporting.service.ZipService;
import com.java.tiny_reporting.utils.generator.ZipGenerator;
import com.java.tiny_reporting.utils.logger.LogUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author qinjiasui.qjs
 * @version ZipServiceImpl: ZipServiceImpl.java, v 0.1 2021年05月17日 下午2:45 qinjiasui.qjs Exp $
 */

@Service
public class ZipServiceImpl implements ZipService {

    /**
     * LOGGER
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ZipServiceImpl.class);

    /**
     * 串行打包文件
     * @param srcFileDir 源文件dir
     * @param destFileDir 打包后文件储存dir
     */
    @Override
    public void serialZip(String srcFileDir, String destFileDir){
        try {
            ZipGenerator.serialZip(srcFileDir, destFileDir);
            System.out.println("文件串行打包完成\r\n");
        } catch (Throwable e) {
            LogUtil.error(LOGGER, e, "串行打包文件出现错误,源文件dir{0}", srcFileDir);
        }
    }

    /**
     * 并行打包文件
     * @param srcFileDir 源文件dir
     * @param destFileDir 打包后文件储存dir
     */
    @Override
    public void parallelZip(String srcFileDir, String destFileDir){
        try {
            ZipGenerator.parallelZip(srcFileDir, destFileDir);
            System.out.println("文件并行打包完成\r\n");
        } catch (Throwable e) {
            LogUtil.error(LOGGER, e, "并行打包文件出现错误, 源文件dir{0}", srcFileDir);
        }
    }
}
