/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.java.tiny_reporting.controller;

import com.java.tiny_reporting.service.DataFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public void prepareFileData(String fileName){
        // todo
        dataFileService.prepareWholeFile(fileName,100);
    }
}