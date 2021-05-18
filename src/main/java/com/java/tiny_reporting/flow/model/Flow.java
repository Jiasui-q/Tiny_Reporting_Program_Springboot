/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.java.tiny_reporting.flow.model;

import com.java.tiny_reporting.flow.nodes.Node;

import javax.annotation.sql.DataSourceDefinition;
import java.util.List;

/**
 * @author qinjiasui.qjs
 * @version Flow: Flow.java, v 0.1 2021年05月17日 下午2:08 qinjiasui.qjs Exp $
 */

public class Flow {

    private String flowCode;

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