/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.java.tiny_reporting.flow;

import com.java.tiny_reporting.dal.dao.TinyFlowConfigDAO;
import com.java.tiny_reporting.dal.dao.TinyFlowInstanceDAO;
import com.java.tiny_reporting.dal.dataobject.TinyFlowInstanceDO;
import com.java.tiny_reporting.model.Status;
import com.java.tiny_reporting.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author qinjiasui.qjs
 * @version FlowInstanceDB: FlowInstanceToDB.java, v 0.1 2021年05月19日 7:34 下午 qinjiasui.qjs Exp $
 */

@Component
public class FlowInstanceToDB {
    @Autowired
    TinyFlowConfigDAO tinyFlowConfigDAO;

    @Autowired
    TinyFlowInstanceDAO tinyFlowInstanceDAO;

    public String getConfigString(Integer configId){
        return tinyFlowConfigDAO.queryJsonConfigByConfigId(configId);
    }

    public void initializeFlowInstance(Integer flowId, Integer configId){
        TinyFlowInstanceDO tinyFlowInstanceDO = new TinyFlowInstanceDO();
        tinyFlowInstanceDO.setFlowId(flowId);
        tinyFlowInstanceDO.setConfigId(configId);
        tinyFlowInstanceDO.setStatus(Status.START.getStatus());
        tinyFlowInstanceDO.setCurrNode("None");
        tinyFlowInstanceDO.setGmtCreate(DateUtil.getGMTDate());
        tinyFlowInstanceDO.setGmtModified(DateUtil.getGMTDate());
        tinyFlowInstanceDAO.insertTinyFlowInstance(tinyFlowInstanceDO);
        System.out.println(tinyFlowInstanceDAO.queryByFlowId(flowId).toString());
    }

    public void updateRunningFlowInstance(Integer flowId, String status, String currNodeCode){
        tinyFlowInstanceDAO.update(status, currNodeCode, DateUtil.getGMTDate(), flowId);
        System.out.println(tinyFlowInstanceDAO.queryByFlowId(flowId).toString());
    }
}
