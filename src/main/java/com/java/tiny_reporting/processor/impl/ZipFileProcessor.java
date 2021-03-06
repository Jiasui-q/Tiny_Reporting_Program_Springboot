/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.java.tiny_reporting.processor.impl;

import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Preconditions;
import com.java.tiny_reporting.processor.NodeProcessor;
import com.java.tiny_reporting.service.ZipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author qinjiasui.qjs
 * @version ZipFileProcessor: ZipFileProcessor.java, v 0.1 2021年05月18日 下午8:03 qinjiasui.qjs Exp $
 */
@Component
public class ZipFileProcessor implements NodeProcessor {

    /**
     * Zip Service - 文件打包
     */
    @Autowired
    private ZipService zipService;

    /**
     * 执行文件打包流程
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

        // 3. 打包文件夹下的文件
        zipService.parallelZip(srcFileDir, destFileDir);
    }
}
