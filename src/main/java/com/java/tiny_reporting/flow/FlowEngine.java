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
import com.java.tiny_reporting.model.Status;
import com.java.tiny_reporting.utils.JsonConfigUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

/**
 * @author jinyu.qjy
 * @version $Id: FlowEngine.java, v 0.1 2021年05月18日 3:46 PM jinyu.qjy Exp $
 */
@Component
public class FlowEngine {

    /**
     * ProcessorInvoker
     */
    @Autowired
    private FlowNodeInvoker invoker;

    /**
     * 用于在 tiny_flow_instance 表中添加或获取数据
     */
    @Autowired
    private FlowInstanceToDB flowInstanceToDB;

    /**
     * 通过配置id从数据库中获取配置并创建flow实例
     *
     * @param configId
     * @return Flow
     */
    public Flow constructAFlow(Integer configId) {

        // 1. 获取 configId 的json配置
        String jsonString = flowInstanceToDB.getConfigString(configId);

        // 2. 通过配置创建flow
        Flow flow = JSONObject.toJavaObject(JsonConfigUtil.getJsonObject(jsonString), Flow.class);

        return flow;
    }

    /**
     * 创建flow执行flow中的node
     *
     * @param flowId
     * @Param configId
     */
    public void perform(Integer flowId, Integer configId) {

        // 1. 创建flow
        Flow flow = constructAFlow(configId);

        // 2. 检查flow是否为null
        Preconditions.checkArgument(flow != null, "Invalid param");

        // 3. 获取此flow含有的的flowNode
        List<FlowNode> nodeList = flow.getNodeList();

        // 4. 检查flowNode数组是否为空
        Preconditions.checkArgument(!CollectionUtils.isEmpty(nodeList), "Empty node list!");

        // 5. 添加flow初始信息进数据库
        flowInstanceToDB.initializeFlowInstance(flowId, configId);

        nodeList.forEach(node -> {
            // 6. 执行每个node所对应processor的process方法
            invoker.invoke(node.getProcessorName(), node.getControlParam());

            // 7. 添加flow执行信息进数据库
            flowInstanceToDB.updateRunningFlowInstance(flowId, Status.RUNNING.getStatus(), node.getNodeCode());
        });

        // 8. 更新flow结束信息进数据库
        flowInstanceToDB.updateRunningFlowInstance(flowId, Status.FINISHED.getStatus(), "None");
    }

}