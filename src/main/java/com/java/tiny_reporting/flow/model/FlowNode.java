/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.java.tiny_reporting.flow.model;

import com.alibaba.fastjson.JSONObject;

/**
 * @author jinyu.qjy
 * @version $Id: FlowNode.java, v 0.1 2021年05月18日 3:43 PM jinyu.qjy Exp $
 */

public class FlowNode {

    /**
     * 节点名称
     */
    private String nodeCode;

    /**
     * 此节点对应的processor
     */
    private String processorName;

    /**
     * processor的参数配置
     */
    private JSONObject controlParam;

    /**
     * Getter method for property <tt>nodeCode</tt>.
     *
     * @return property value of nodeCode
     */
    public String getNodeCode() {
        return nodeCode;
    }

    /**
     * Setter method for property <tt>nodeCode</tt>.
     *
     * @param nodeCode value be assigned to nodeCode
     */
    public void setNodeCode(String nodeCode) {
        this.nodeCode = nodeCode;
    }

    /**
     * Getter method for property <tt>processorName</tt>.
     *
     * @return property value of processorName
     */
    public String getProcessorName() {
        return processorName;
    }

    /**
     * Setter method for property <tt>processorName</tt>.
     *
     * @param processorName value be assigned to processorName
     */
    public void setProcessorName(String processorName) {
        this.processorName = processorName;
    }

    /**
     * Getter method for property <tt>controlParam</tt>.
     *
     * @return property value of controlParam
     */
    public JSONObject getControlParam() {
        return controlParam;
    }

    /**
     * Setter method for property <tt>controlParam</tt>.
     *
     * @param controlParam value be assigned to controlParam
     */
    public void setControlParam(JSONObject controlParam) {
        this.controlParam = controlParam;
    }
}