/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.java.tiny_reporting.processor.impl;

import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Preconditions;
import com.java.tiny_reporting.processor.NodeProcessor;
import com.java.tiny_reporting.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author qinjiasui.qjs
 * @version LogFileProcessor: LogFileProcessor.java, v 0.1 2021年05月18日 下午7:59 qinjiasui.qjs Exp $
 */
@Component
public class LogFileProcessor implements NodeProcessor {

    /**
     * Log Service - 生成log文件
     */
    @Autowired
    private LogService logService;

    /**
     * 执行生成log文件
     *
     * @param controlParam
     */
    @Override
    public void process(JSONObject controlParam) {

        // 1. 检查controlParam是否为null
        Preconditions.checkArgument(controlParam!=null,"Empty controlParam");

        // 2. 解析controlParam
        String srcFileDir = controlParam.getString("srcFileDir");
        String destFileDir = controlParam.getString("destFileDir");

        // 3. 为文件夹下文件生成log文件
        logService.prepareLogFileFromDir(srcFileDir, destFileDir);
    }
}
