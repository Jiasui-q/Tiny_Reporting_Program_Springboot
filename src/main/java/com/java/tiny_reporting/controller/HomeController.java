/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.java.tiny_reporting.controller;

import com.java.tiny_reporting.service.DataFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * Just a Controller
 *
 * @author jinyu.qjy
 * @version $Id: HomeController.java, v 0.1 2021年05月11日 9:31 AM jinyu.qjy Exp $
 */
@Controller
public class HomeController {

    /**
     * DataFileService
     */
    @Autowired
    private DataFileService dataFileService;

    /**
     * just a index
     * @return
     */
    @RequestMapping("/index")
    public String sayHello() {
        return "index";
    }

    /**
     * 准备文件哦
     */
    @RequestMapping("/prepareFile.json")
    public void prepareFileData(){
        // todo
        dataFileService.prepareFileData(100);
    }
}