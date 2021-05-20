/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.java.tiny_reporting.controller;

import com.java.tiny_reporting.dal.daoservice.TinyBIzInfoDAOService;
import com.java.tiny_reporting.dal.daoservice.TinyFlowConfigDAOService;
import com.java.tiny_reporting.dal.daoservice.TinyFlowInstanceDAOService;
import com.java.tiny_reporting.dal.dataobject.TinyBizInfoDO;
import com.java.tiny_reporting.flow.FlowEngine;
import com.java.tiny_reporting.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    private FlowEngine flowEngine;

    @Autowired
    private TinyBIzInfoDAOService tinyBIzInfoDAOService;

    @Autowired
    private TinyFlowConfigDAOService tinyFlowConfigDAOService;

    @Autowired
    private TinyFlowInstanceDAOService tinyFlowInstanceDAOService;

    /**
     * GET 返回 tinyBizInfo 添加页面
     * @GetMapping("/tinyBizInfo/add") = @RequestMapping(method = RequestMethod.GET, value = "/tinyBizInfo/add")
     * */
    @GetMapping("/tinyBizInfo/add")
    public String addTinyBizInfo(){
        return "add";
    }

    /**
     * POST 新增 BizInfo
     * @return
     * */
    @GetMapping("/tinyBizInfo/save")
    @ResponseBody
    public String saveTinyBizInfo(@RequestParam("bizInfoId") Integer bizInfoId, @RequestParam("bizName") String bizName,
                                  @RequestParam("bu") String bu, @RequestParam("owner") String owner,
                                  @RequestParam("description") String description){
        tinyBIzInfoDAOService.addNewBizInfo(bizInfoId, bizName, bu, owner, description);
        return "添加Biz Info：" + tinyBIzInfoDAOService.findBizInfoById(bizInfoId);
    }

    /**
     * POST 新增 BizInfo
     * @return
     * */
    @GetMapping("/tinyBizInfo/test")
    @ResponseBody
    public String testTinyBizInfo(@RequestParam("bizInfoId") Integer bizInfoId, @RequestParam("bizName") String bizName){
        return "Added " + bizInfoId + ", " + bizName;
    }

    /**
     * GET 返回所有tinyBizInfo
     * */
    @GetMapping("/tinyBizInfo/show")
    @ResponseBody
    public List<TinyBizInfoDO> showAllBizInfo(){
        return tinyBIzInfoDAOService.findAllBizInfo();
    }

    /**
     * GET 根据id返回单个tinyBizInfo
     * */
    @GetMapping(value = "/tinyBizInfo/show/{bizInfoId}")
    @ResponseBody
    public TinyBizInfoDO showBizInfoById(@PathVariable("bizInfoId") Integer bizInfoId){
        return tinyBIzInfoDAOService.findBizInfoById(bizInfoId);
    }


    /**
     * just a index
     * @return
     */
    @RequestMapping("/runFlow")
    public void runFlow(@RequestParam("flowId") Integer flowId, @RequestParam("configId") Integer configId) {
        flowEngine.perform(flowId, configId);
    }
}