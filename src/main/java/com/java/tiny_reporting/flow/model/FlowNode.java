/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.java.tiny_reporting.flow.model;

import com.alibaba.fastjson.JSONObject;

/**
 * @author qinjiasui.qjs
 * @version FlowNode: FlowNode.java, v 0.1 2021年05月18日 下午4:58 qinjiasui.qjs Exp $
 */
public class FlowNode {

    private String nodeCode;

    private String nodeName;

    private String processorName;

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
     * Getter method for property <tt>nodeName</tt>.
     *
     * @return property value of nodeName
     */
    public String getNodeName() {
        return nodeName;
    }

    /**
     * Setter method for property <tt>nodeName</tt>.
     *
     * @param nodeName value be assigned to nodeName
     */
    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
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
