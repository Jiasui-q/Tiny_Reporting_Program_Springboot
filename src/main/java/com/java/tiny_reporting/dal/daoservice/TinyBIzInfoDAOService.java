/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.java.tiny_reporting.dal.daoservice;

/**
 * @author qinjiasui.qjs
 * @version TinyBIzInfoDAOService: TinyBIzInfoDAOService.java, v 0.1 2021年05月20日 11:11 上午 qinjiasui.qjs Exp $
 */

public interface TinyBIzInfoDAOService {

    void addNewBizInfo(Integer bizInfoId, String bizName, String bu, String owner, String description);

    void updateBizInfo(String bizName, String bu, String owner, String description, Integer bizInfoId);

    void deleteBizInfoById(Integer bizInfoId);

}