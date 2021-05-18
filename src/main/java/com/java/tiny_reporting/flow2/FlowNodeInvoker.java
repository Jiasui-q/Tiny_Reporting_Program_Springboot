/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.java.tiny_reporting.flow2;

import java.util.Map;

import com.alibaba.fastjson.JSONObject;

import com.google.common.base.Preconditions;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author jinyu.qjy
 * @version $Id: FlowNodeInvoker.java, v 0.1 2021年05月18日 4:05 PM jinyu.qjy Exp $
 */
@Component
public class FlowNodeInvoker implements ApplicationContextAware {

    /**
     * application context
     */
    private ApplicationContext applicationContext;

    /**
     * Set the ApplicationContext
     *
     * @see ApplicationContextAware#setApplicationContext(org.springframework.context.ApplicationContext)
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    // ~~~~~~~~~~~~~~~~~~~私有方法~~~~~~~~~~~~~~~~~~~~

    public void invoke(String nodeProcessorName, JSONObject controlParam) {

        Preconditions.checkArgument(StringUtils.isNotBlank(nodeProcessorName), "Blank String!");

        NodeProcessor processorBean = getProcessorBean(nodeProcessorName);
        Preconditions.checkNotNull(processorBean, "处理器获取异常,nodeProcessorName=" + nodeProcessorName);

        processorBean.process(controlParam);
    }

    /**
     * 获取processor bean
     *
     * @param name
     * @param <T>
     * @return
     * @throws BeansException
     */
    @SuppressWarnings("unchecked")
    private <T> T getProcessorBean(String name) throws BeansException {
        if (applicationContext == null) {
            return null;
        }
        return (T) applicationContext.getBean(name);
    }
}