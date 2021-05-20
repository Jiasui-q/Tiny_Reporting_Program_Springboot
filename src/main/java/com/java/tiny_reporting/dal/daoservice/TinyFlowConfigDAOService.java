/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.java.tiny_reporting.dal.daoservice;

/**
 * @author qinjiasui.qjs
 * @version TinyFlowConfigDAOService: TinyFlowConfigDAOService.java, v 0.1 2021年05月20日 11:14 上午 qinjiasui.qjs Exp $
 */
public interface TinyFlowConfigDAOService {

    void addNewFlowConfig(Integer bizInfoId, Integer configId, String jsonConfig);

    void updateFlowConfig(String jsonConfig, Integer configId);

    void deleteFlowConfigById(Integer configId);

    String getConfigString(Integer configId);

}