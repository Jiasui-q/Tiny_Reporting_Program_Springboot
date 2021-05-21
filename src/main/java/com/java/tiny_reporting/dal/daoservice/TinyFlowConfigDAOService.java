/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.java.tiny_reporting.dal.daoservice;

import com.java.tiny_reporting.dal.dataobject.TinyBizInfoDO;
import com.java.tiny_reporting.dal.dataobject.TinyFlowConfigDO;

import java.util.List;

/**
 * @author qinjiasui.qjs
 * @version TinyFlowConfigDAOService: TinyFlowConfigDAOService.java, v 0.1 2021年05月20日 11:14 上午 qinjiasui.qjs Exp $
 */
public interface TinyFlowConfigDAOService {

    void addNewFlowConfig(Integer bizInfoId, Integer configId, String jsonConfig);

    TinyFlowConfigDO findFlowConfigById(Integer configId);

    List<TinyFlowConfigDO> findAllFlowConfig();

    void updateFlowConfig(String jsonConfig, Integer configId);

    void deleteFlowConfigById(Integer configId);

    String getConfigString(Integer configId);

}