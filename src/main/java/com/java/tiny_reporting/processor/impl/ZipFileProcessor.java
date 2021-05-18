/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.java.tiny_reporting.processor.impl;

import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Preconditions;
import com.java.tiny_reporting.processor.NodeProcessor;
import com.java.tiny_reporting.service.LogService;
import com.java.tiny_reporting.service.ZipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author qinjiasui.qjs
 * @version ZipFileProcessor: ZipFileProcessor.java, v 0.1 2021年05月18日 下午8:03 qinjiasui.qjs Exp $
 */
@Component
public class ZipFileProcessor implements NodeProcessor {

    @Autowired
    private ZipService zipService;

    /**
     * 执行文件打包流程
     *
     * @param controlParam
     */
    @Override
    public void process(JSONObject controlParam) {

        Preconditions.checkArgument(controlParam!=null,"Empty controlParam");

        String srcFileDir = controlParam.getString("srcFileDir");
        String destFileDir = controlParam.getString("destFileDir");

        zipService.parallelZip(srcFileDir, destFileDir);
    }
}
