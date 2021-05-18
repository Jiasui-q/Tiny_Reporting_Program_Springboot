/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.java.tiny_reporting.flow;

import java.util.List;

import com.alibaba.fastjson.JSONObject;

import com.google.common.base.Preconditions;
import com.java.tiny_reporting.flow.model.Flow;
import com.java.tiny_reporting.flow.model.FlowNode;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

/**
 * @author qinjiasui.qjs
 * @version FlowEngine: FlowEngine.java, v 0.1 2021年05月17日 下午2:07 qinjiasui.qjs Exp $
 */
@Component
public class FlowEngine {

    /**
     * ProcessorInvoker
     */
    @Autowired
    private FlowNodeInvoker invoker;

    /**
     * @param jsonConfig
     * @return
     */
    public Flow constructAFlow(String jsonConfig) {

        Preconditions.checkArgument(StringUtils.isNotBlank(jsonConfig), "Blank String!");

        Flow flow = JSONObject.parseObject(jsonConfig, Flow.class);
        return flow;
    }

    /**
     *
     */
    public void perform(Flow flow) {

        Preconditions.checkArgument(flow != null, "Invalid param");

        List<FlowNode> nodeList = flow.getNodeList();
        Preconditions.checkArgument(!CollectionUtils.isEmpty(nodeList), "Empty node list!");

        nodeList.forEach(node -> invoker.invoke(node.getProcessorName(), node.getControlParam()));
    }
}