/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.java.tiny_reporting.processor;

import com.alibaba.fastjson.JSONObject;

/**
 * @author jinyu.qjy
 * @version $Id: NodeProcessor.java, v 0.1 2021年05月18日 4:15 PM jinyu.qjy Exp $
 */
public interface NodeProcessor {

    /**
     * 根据配置执行node流程
     * @param controlParam
     */
    void process(JSONObject controlParam);
}