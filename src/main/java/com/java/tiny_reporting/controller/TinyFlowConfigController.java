/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.java.tiny_reporting.controller;

import com.java.tiny_reporting.dal.daoservice.TinyFlowConfigDAOService;
import com.java.tiny_reporting.dal.dataobject.TinyFlowConfigDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * @author qinjiasui.qjs
 * @version tinyFlowConfigController: tinyFlowConfigController.java, v 0.1 2021年05月21日 3:35 下午 qinjiasui.qjs Exp $
 */
@Controller
public class TinyFlowConfigController {

    @Autowired
    private TinyFlowConfigDAOService tinyFlowConfigDAOService;

    /**
     * GET 返回 tinyFlowConfig 添加页面
     * */
    @GetMapping("/flowConfig/add")
    public String addFlowConfig(TinyFlowConfigDO tinyFlowConfigDO){
        return "flowConfig/add";
    }

    /**
     * POST 新增 tinyFlowConfig
     * */
    @PostMapping("/flowConfig/add")
    public String saveFlowConfig(TinyFlowConfigDO tinyFlowConfigDO, RedirectAttributes redirectAttrs) {
        tinyFlowConfigDAOService.addNewFlowConfig(tinyFlowConfigDO.getConfigId(), tinyFlowConfigDO.getBizInfoId(), tinyFlowConfigDO.getJsonConfig());
        redirectAttrs.addAttribute("configId", tinyFlowConfigDO.getConfigId());
        return "redirect:/flowConfig/show/{configId}";
    }

    /**
     * GET 返回 tinyFlowConfig 搜索页面
     * */
    @GetMapping("/flowConfig/search")
    public String searchFlowConfig(TinyFlowConfigDO tinyFlowConfigDO){
        return "flowConfig/search";
    }

    /**
     * POST 获取 tinyFlowConfig
     * */
    @PostMapping("/flowConfig/search")
    public String searchFlowConfigById(TinyFlowConfigDO tinyFlowConfigDO, RedirectAttributes redirectAttrs) {
        redirectAttrs.addAttribute("configId", tinyFlowConfigDO.getConfigId());
        return "redirect:/flowConfig/show/{configId}";
    }

    /**
     * GET 返回所有 tinyFlowConfig
     * */
    @GetMapping("/flowConfig/show")
    @ResponseBody
    public List<TinyFlowConfigDO> showAllFlowConfig(){
        return tinyFlowConfigDAOService.findAllFlowConfig();
    }

    /**
     * GET 根据id返回单个tinyFlowConfig
     * */
    @GetMapping(value = "/flowConfig/show/{configId}")
    @ResponseBody
    public TinyFlowConfigDO showFlowConfigById(@PathVariable("configId") Integer configId){
        return tinyFlowConfigDAOService.findFlowConfigById(configId);
    }

    /**
     * GET 返回 tinyFlowConfig 删除页面
     * */
    @GetMapping("/flowConfig/delete")
    public String deleteFlowConfig(TinyFlowConfigDO tinyFlowConfigDO){
        return "flowConfig/delete";
    }

    /**
     * POST 删除 tinyFlowConfig
     * */
    @PostMapping("/flowConfig/delete")
    public String deleteFlowConfigById(TinyFlowConfigDO tinyFlowConfigDO, RedirectAttributes redirectAttrs) {
        tinyFlowConfigDAOService.deleteFlowConfigById(tinyFlowConfigDO.getConfigId());
        redirectAttrs.addAttribute("configId", tinyFlowConfigDO.getConfigId());
        return "redirect:/flowConfig/delete/{configId}";
    }

    /**
     * GET 删除成功删除 tinyFlowConfig 页面
     */
    @GetMapping(value = "/flowConfig/delete/{configId}")
    @ResponseBody
    public String deleteFlowConfigById(@PathVariable("configId") Integer configId) {
        return "成功删除 FlowConfigID=" + configId;
    }
}
