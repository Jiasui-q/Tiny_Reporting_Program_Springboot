/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.java.tiny_reporting.processor.impl;

import com.alibaba.fastjson.JSONObject;

import com.google.common.base.Preconditions;
import com.java.tiny_reporting.processor.NodeProcessor;
import com.java.tiny_reporting.service.CipherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author qinjiasui.qjs
 * @version CipherNode: CipherNode.java, v 0.1 2021年05月17日 下午5:09 qinjiasui.qjs Exp $
 */

@Component
public class CipherProcessor implements NodeProcessor {

    /**
     * Cipher Service - 加密
     */
    @Autowired
    private CipherService cipherService;

    /**
     * 执行文件加密流程
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
        String password = controlParam.getString("password");

        // 3. 为文件夹下的文件加密
        cipherService.encryptFileFromDir(srcFileDir, destFileDir, password);
    }
}
