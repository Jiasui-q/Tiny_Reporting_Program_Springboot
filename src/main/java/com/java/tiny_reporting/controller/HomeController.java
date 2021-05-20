/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.java.tiny_reporting.controller;

import com.java.tiny_reporting.dal.daoservice.TinyBIzInfoDAOService;
import com.java.tiny_reporting.dal.daoservice.TinyFlowConfigDAOService;
import com.java.tiny_reporting.dal.daoservice.TinyFlowInstanceDAOService;
import com.java.tiny_reporting.flow.FlowEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
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
     * GET 返回add页面
     * @GetMapping("/add") = @RequestMapping(method = RequestMethod.GET,value = "/add")
     * */
    @GetMapping("/add")
    public String add(){
        return "add";
    }

    /**
     * just a index
     * @return
     */
    @RequestMapping("/index")
    public String sayHello() {
        return "index";
    }

    /**
     * just a index
     * @return
     */
    @RequestMapping("/runFlow")
    public void runFlow() {
        flowEngine.perform(1, 1);
    }

    /**
     * 准备文件哦
     */
    @RequestMapping("/addBizInfo.json")
    public void prepareFileData(String fileName){
        // todo
    }
}