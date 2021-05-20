/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.java.tiny_reporting.dal.daoservice.impl;

import com.java.tiny_reporting.dal.dao.TinyFlowConfigDAO;
import com.java.tiny_reporting.dal.daoservice.TinyFlowConfigDAOService;
import com.java.tiny_reporting.dal.dataobject.TinyFlowConfigDO;
import com.java.tiny_reporting.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author qinjiasui.qjs
 * @version TinyFlowConfigDAOService: TinyFlowConfigDAOService.java, v 0.1 2021年05月20日 10:28 上午 qinjiasui.qjs Exp $
 */

@Service
public class TinyFlowConfigDAOServiceImpl implements TinyFlowConfigDAOService {

    @Autowired
    private TinyFlowConfigDAO tinyFlowConfigDAO;

    @Override
    public void addNewFlowConfig(Integer bizInfoId, Integer configId, String jsonConfig){
        TinyFlowConfigDO tinyFlowConfigDO = new TinyFlowConfigDO();
        tinyFlowConfigDO.setConfigId(configId);
        tinyFlowConfigDO.setBizInfoId(bizInfoId);
        tinyFlowConfigDO.setGmtCreate(DateUtil.getNow());
        tinyFlowConfigDO.setGmtModified(DateUtil.getNow());
        tinyFlowConfigDO.setJsonConfig(jsonConfig);
        tinyFlowConfigDAO.insertTinyFlowConfig(tinyFlowConfigDO);
        System.out.println(tinyFlowConfigDAO.queryByConfigId(configId).toString());
    }

    @Override
    public void updateFlowConfig(String jsonConfig, Integer configId){
        tinyFlowConfigDAO.update(jsonConfig, DateUtil.getNow(), configId);
        System.out.println(tinyFlowConfigDAO.queryByConfigId(configId).toString());
    }

    @Override
    public void deleteFlowConfigById(Integer configId){
        tinyFlowConfigDAO.deleteByConfigId(configId);
    }

    @Override
    public String getConfigString(Integer configId){
        return tinyFlowConfigDAO.queryJsonConfigByConfigId(configId);
    }

}
