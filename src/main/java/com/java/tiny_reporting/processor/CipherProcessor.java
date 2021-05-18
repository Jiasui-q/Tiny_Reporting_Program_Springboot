/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.java.tiny_reporting.processor;

import com.alibaba.fastjson.JSONObject;

import com.google.common.base.Preconditions;
import com.java.tiny_reporting.flow2.NodeProcessor;
import com.java.tiny_reporting.service.CipherService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author qinjiasui.qjs
 * @version CipherNode: CipherNode.java, v 0.1 2021年05月17日 下午5:09 qinjiasui.qjs Exp $
 */
@Component
public class CipherProcessor implements NodeProcessor {

    @Autowired
    private CipherService cipherService;

    /**
     * @param controlParam
     */
    @Override
    public void process(JSONObject controlParam) {

        Preconditions.checkArgument(controlParam!=null,"Empty controlParam");
        String srcFileDir = controlParam.getString("srcFileDir");
        String encryptFileDir = controlParam.getString("encryptFileDir");
        String password = controlParam.getString("password");

        cipherService.encryptFileFromDir(srcFileDir, encryptFileDir, password);
    }
}
