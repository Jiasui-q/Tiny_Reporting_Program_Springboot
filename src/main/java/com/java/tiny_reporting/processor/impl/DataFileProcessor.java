/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.java.tiny_reporting.processor.impl;

import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Preconditions;
import com.java.tiny_reporting.processor.NodeProcessor;
import com.java.tiny_reporting.service.DataFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author qinjiasui.qjs
 * @version DataFileProcessor: DataFileProcessor.java, v 0.1 2021年05月18日 下午5:46 qinjiasui.qjs Exp $
 */
@Component
public class DataFileProcessor implements NodeProcessor {

    @Autowired
    private DataFileService dataFileService;

    /**
     * 执行生成文件和拆分流程
     *
     * @param controlParam
     */
    @Override
    public void process(JSONObject controlParam) {

        Preconditions.checkArgument(controlParam!=null,"Empty controlParam");

        String wholeFilePath = controlParam.getString("wholeFilePath");
        String splitFileDir = controlParam.getString("splitFileDir");
        String splitFileName = controlParam.getString("splitFileName");
        int totalCount = controlParam.getIntValue("totalCount");
        int eachFileCount = controlParam.getIntValue("eachFileCount");

        dataFileService.prepareWholeFile(wholeFilePath, totalCount);
        dataFileService.splitFile(wholeFilePath, splitFileDir, splitFileName, eachFileCount);
    }
}
