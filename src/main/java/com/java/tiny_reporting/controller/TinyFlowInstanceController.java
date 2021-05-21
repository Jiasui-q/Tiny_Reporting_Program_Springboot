/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.java.tiny_reporting.controller;

import com.java.tiny_reporting.dal.daoservice.TinyFlowInstanceDAOService;
import com.java.tiny_reporting.dal.dataobject.TinyFlowInstanceDO;
import com.java.tiny_reporting.flow.FlowEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * @author qinjiasui.qjs
 * @version TinyFlowInstanceController: TinyFlowInstanceController.java, v 0.1 2021年05月21日 4:41 下午 qinjiasui.qjs Exp $
 */
@Controller
public class TinyFlowInstanceController {
    @Autowired
    FlowEngine flowEngine;

    @Autowired
    private TinyFlowInstanceDAOService tinyFlowInstanceDAOService;

    /**
     * GET 返回 tinyFlowInstance 添加页面
     * */
    @GetMapping("/flowInstance/add")
    public String addFlowInstance(TinyFlowInstanceDO tinyFlowInstanceDO){
        return "flowInstance/add";
    }

    /**
     * POST 新增 tinyFlowInstance
     * */
    @PostMapping("/flowInstance/add")
    public String runFlowInstance(TinyFlowInstanceDO tinyFlowInstanceDO, RedirectAttributes redirectAttrs) {
        redirectAttrs.addAttribute("flowId", tinyFlowInstanceDO.getFlowId());
        flowEngine.perform(tinyFlowInstanceDO.getFlowId(), tinyFlowInstanceDO.getConfigId());
        return "redirect:/flowInstance/show/{flowId}";
    }

    /**
     * GET 返回 tinyFlowInstance 搜索页面
     * */
    @GetMapping("/flowInstance/search")
    public String searchFlowInstance(TinyFlowInstanceDO tinyFlowInstanceDO){
        return "flowInstance/search";
    }

    /**
     * POST 获取 tinyFlowInstance
     * */
    @PostMapping("/flowInstance/search")
    public String searchFlowConfigById(TinyFlowInstanceDO tinyFlowInstanceDO, RedirectAttributes redirectAttrs) {
        redirectAttrs.addAttribute("flowId", tinyFlowInstanceDO.getFlowId());
        return "redirect:/flowInstance/show/{flowId}";
    }

    /**
     * GET 返回所有 tinyFlowInstance
     * */
    @GetMapping("/flowInstance/show")
    @ResponseBody
    public List<TinyFlowInstanceDO> showAllFlowInstance(){
        return tinyFlowInstanceDAOService.findAllFlowInstance();
    }

    /**
     * GET 根据id返回单个tinyFlowInstance
     * */
    @GetMapping(value = "/flowInstance/show/{flowId}")
    @ResponseBody
    public TinyFlowInstanceDO showFlowInstanceById(@PathVariable("flowId") Integer flowId){
        return tinyFlowInstanceDAOService.findFlowInstanceById(flowId);
    }

    /**
     * GET 返回 tinyFlowInstance 删除页面
     * */
    @GetMapping("/flowInstance/delete")
    public String deleteFlowInstance(TinyFlowInstanceDO tinyFlowInstanceDO){
        return "flowInstance/delete";
    }

    /**
     * POST 删除 tinyFlowInstance
     * */
    @PostMapping("/flowInstance/delete")
    public String deleteFlowInstanceById(TinyFlowInstanceDO tinyFlowInstanceDO, RedirectAttributes redirectAttrs) {
        tinyFlowInstanceDAOService.deleteFlowInstanceById(tinyFlowInstanceDO.getFlowId());
        redirectAttrs.addAttribute("flowId", tinyFlowInstanceDO.getFlowId());
        return "redirect:/flowInstance/successDelete";
    }

    /**
     * GET 返回成功删除 tinyFlowInstance 页面
     */
    @GetMapping(value = "/flowInstance/successDelete")
    public String deleteFlowInstanceById() {
        return "flowInstance/successDelete";
    }


}
