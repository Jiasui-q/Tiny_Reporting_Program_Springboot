/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.java.tiny_reporting.processor.impl;

import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Preconditions;
import com.java.tiny_reporting.processor.NodeProcessor;
import com.java.tiny_reporting.service.DataFileService;
import com.java.tiny_reporting.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author qinjiasui.qjs
 * @version LogFileProcessor: LogFileProcessor.java, v 0.1 2021年05月18日 下午7:59 qinjiasui.qjs Exp $
 */
@Component
public class LogFileProcessor implements NodeProcessor {

    @Autowired
    private LogService logService;

    /**
     * 执行生成log文件
     *
     * @param controlParam
     */
    @Override
    public void process(JSONObject controlParam) {

        Preconditions.checkArgument(controlParam!=null,"Empty controlParam");

        String srcFileDir = controlParam.getString("srcFileDir");
        String destFileDir = controlParam.getString("destFileDir");

        logService.prepareLogFileFromDir(srcFileDir, destFileDir);
    }
}
