/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.java.tiny_reporting.flow;

import com.java.tiny_reporting.flow.nodes.Node;

import java.util.List;

/**
 * @author qinjiasui.qjs
 * @version Flow: Flow.java, v 0.1 2021年05月17日 下午2:08 qinjiasui.qjs Exp $
 */
public class Flow {
    private String flowName;
    private List<Node> nodeList;

    public String getFlowName() {
        return flowName;
    }

    public void setFlowName(String flowName) {
        this.flowName = flowName;
    }

    public List<Node> getNodeList() {
        return nodeList;
    }

    public void setNodeList(List<Node> nodeList) {
        this.nodeList = nodeList;
    }
}
