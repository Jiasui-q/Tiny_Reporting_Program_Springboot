/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.java.tiny_reporting.dal.daoservice.impl;

import com.java.tiny_reporting.dal.dao.TinyBizInfoDAO;
import com.java.tiny_reporting.dal.daoservice.TinyBIzInfoDAOService;
import com.java.tiny_reporting.dal.dataobject.TinyBizInfoDO;
import com.java.tiny_reporting.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author qinjiasui.qjs
 * @version TinyBizInfoDAOService: TinyBizInfoDAOService.java, v 0.1 2021年05月20日 10:29 上午 qinjiasui.qjs Exp $
 */

@Service
public class TinyBizInfoDAOServiceImpl implements TinyBIzInfoDAOService {

    @Autowired
    private TinyBizInfoDAO tinyBizInfoDAO;

    @Override
    public void addNewBizInfo(Integer bizInfoId, String bizName, String bu, String owner, String description){
        TinyBizInfoDO tinyBizInfoDO = new TinyBizInfoDO();
        tinyBizInfoDO.setBizInfoId(bizInfoId);
        tinyBizInfoDO.setBizName(bizName);
        tinyBizInfoDO.setBu(bu);
        tinyBizInfoDO.setOwner(owner);
        tinyBizInfoDO.setDescription(description);
        tinyBizInfoDO.setGmtCreate(DateUtil.getNow());
        tinyBizInfoDO.setGmtModified(DateUtil.getNow());
        tinyBizInfoDAO.insertTinyBizInfo(tinyBizInfoDO);
        System.out.println(tinyBizInfoDAO.queryByBizInfoId(bizInfoId).toString());
    }

    @Override
    public TinyBizInfoDO findBizInfoById(Integer bizInfoId){
        return tinyBizInfoDAO.queryByBizInfoId(bizInfoId);
    }

    @Override
    public List<TinyBizInfoDO> findAllBizInfo(){
        return tinyBizInfoDAO.queryAllBizInfo();
    }

    @Override
    public void updateBizInfo(String bizName, String bu, String owner, String description, Integer bizInfoId){
        TinyBizInfoDO tinyBizInfoDO = new TinyBizInfoDO();
        tinyBizInfoDO.setBizInfoId(bizInfoId);
        tinyBizInfoDO.setBizName(bizName);
        tinyBizInfoDO.setBu(bu);
        tinyBizInfoDO.setOwner(owner);
        tinyBizInfoDO.setDescription(description);
        tinyBizInfoDO.setGmtCreate(DateUtil.getNow());
        tinyBizInfoDO.setGmtModified(DateUtil.getNow());
        tinyBizInfoDAO.update(tinyBizInfoDO);
        System.out.println(tinyBizInfoDAO.queryByBizInfoId(bizInfoId).toString());
    }

    @Override
    public void deleteBizInfoById(Integer bizInfoId){
        tinyBizInfoDAO.deleteByBizInfoId(bizInfoId);
    }

}
