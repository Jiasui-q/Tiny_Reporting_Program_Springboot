/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.java.tiny_reporting.flow.model;

import java.util.List;

/**
 * @author jinyu.qjy
 * @version $Id: Flow.java, v 0.1 2021年05月18日 3:43 PM jinyu.qjy Exp $
 */

public class Flow {

    /**
     * flow名称
     */
    private String flowCode;

    /**
     * flow含有的FlowNode
     */
    private List<FlowNode> nodeList;

    /**
     * Getter method for property <tt>flowCode</tt>.
     *
     * @return property value of flowCode
     */
    public String getFlowCode() {
        return flowCode;
    }

    /**
     * Setter method for property <tt>flowCode</tt>.
     *
     * @param flowCode value be assigned to flowCode
     */
    public void setFlowCode(String flowCode) {
        this.flowCode = flowCode;
    }

    /**
     * Getter method for property <tt>nodeList</tt>.
     *
     * @return property value of nodeList
     */
    public List<FlowNode> getNodeList() {
        return nodeList;
    }

    /**
     * Setter method for property <tt>nodeList</tt>.
     *
     * @param nodeList value be assigned to nodeList
     */
    public void setNodeList(List<FlowNode> nodeList) {
        this.nodeList = nodeList;
    }
}