/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.java.tiny_reporting.dal.daoservice.impl;

import com.java.tiny_reporting.dal.dao.TinyFlowInstanceDAO;
import com.java.tiny_reporting.dal.daoservice.TinyFlowInstanceDAOService;
import com.java.tiny_reporting.dal.dataobject.TinyFlowInstanceDO;
import com.java.tiny_reporting.model.enums.FlowStatusEnum;
import com.java.tiny_reporting.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author qinjiasui.qjs
 * @version FlowInstanceDB: FlowInstanceToDB.java, v 0.1 2021年05月19日 7:34 下午 qinjiasui.qjs Exp $
 */

@Service
public class TinyFlowInstanceDAOServiceImpl implements TinyFlowInstanceDAOService {

    @Autowired
    private TinyFlowInstanceDAO tinyFlowInstanceDAO;

    @Override
    public void initializeFlowInstance(Integer flowId, Integer configId){
        TinyFlowInstanceDO tinyFlowInstanceDO = new TinyFlowInstanceDO();
        tinyFlowInstanceDO.setFlowId(flowId);
        tinyFlowInstanceDO.setConfigId(configId);
        tinyFlowInstanceDO.setStatus(FlowStatusEnum.getByCode("START").getMessage());
        tinyFlowInstanceDO.setCurrNode("None");
        tinyFlowInstanceDO.setGmtCreate(DateUtil.getNow());
        tinyFlowInstanceDO.setGmtModified(DateUtil.getNow());
        tinyFlowInstanceDAO.insertTinyFlowInstance(tinyFlowInstanceDO);
        System.out.println(tinyFlowInstanceDAO.queryByFlowId(flowId).toString());
    }

    @Override
    public TinyFlowInstanceDO findFlowInstanceById(Integer flowId){
        return tinyFlowInstanceDAO.queryByFlowId(flowId);
    }

    @Override
    public List<TinyFlowInstanceDO> findAllFlowInstance(){
        return tinyFlowInstanceDAO.queryAllFlowInstance();
    }

    @Override
    public void updateFlowInstance(Integer flowId, String status, String currNodeCode){
        tinyFlowInstanceDAO.update(status, currNodeCode, DateUtil.getNow(), flowId);
        System.out.println(tinyFlowInstanceDAO.queryByFlowId(flowId).toString());
    }

    @Override
    public void deleteFlowInstanceById(Integer flowId){
        tinyFlowInstanceDAO.deleteByFlowId(flowId);
    }

}
