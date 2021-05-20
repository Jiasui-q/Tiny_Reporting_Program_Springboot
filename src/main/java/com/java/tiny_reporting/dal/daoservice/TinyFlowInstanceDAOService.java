/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.java.tiny_reporting.dal.daoservice;

/**
 * @author qinjiasui.qjs
 * @version TinyFlowInstanceDAOService: TinyFlowInstanceDAOService.java, v 0.1 2021年05月20日 11:16 上午 qinjiasui.qjs Exp $
 */
public interface TinyFlowInstanceDAOService {

    void initializeFlowInstance(Integer flowId, Integer configId);

    void updateFlowInstance(Integer flowId, String status, String currNodeCode);

    void deleteFlowInstanceById(Integer flowId);

}