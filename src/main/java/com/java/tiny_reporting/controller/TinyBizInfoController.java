/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.java.tiny_reporting.controller;

import com.java.tiny_reporting.dal.daoservice.TinyBIzInfoDAOService;
import com.java.tiny_reporting.dal.dataobject.TinyBizInfoDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class TinyBizInfoController {

    @Autowired
    private TinyBIzInfoDAOService tinyBIzInfoDAOService;

    /**
     * GET 返回 tinyBizInfo 添加页面
     * */
    @GetMapping("/bizInfo/add")
    public String addBizInfo(TinyBizInfoDO tinyBizInfoDO){
        return "bizInfo/add";
    }

    /**
     * POST 新增 tinyBizInfo
     * */
    @PostMapping("/bizInfo/add")
    public String saveBizInfo(TinyBizInfoDO tinyBizInfoDO, RedirectAttributes redirectAttrs) {
        tinyBIzInfoDAOService.addNewBizInfo(tinyBizInfoDO.getBizInfoId(), tinyBizInfoDO.getBizName(), tinyBizInfoDO.getBu(), tinyBizInfoDO.getOwner(), tinyBizInfoDO.getDescription());
        redirectAttrs.addAttribute("bizInfoId", tinyBizInfoDO.getBizInfoId());
        return "redirect:/bizInfo/show/{bizInfoId}";
    }

    /**
     * GET 返回 tinyBizInfo 搜索页面
     * */
    @GetMapping("/bizInfo/search")
    public String searchBizInfo(TinyBizInfoDO tinyBizInfoDO){
        return "bizInfo/search";
    }

    /**
     * POST 获取 tinyBizInfo
     * */
    @PostMapping("/bizInfo/search")
    public String searchBizInfoById(TinyBizInfoDO tinyBizInfoDO, RedirectAttributes redirectAttrs) {
        redirectAttrs.addAttribute("bizInfoId", tinyBizInfoDO.getBizInfoId());
        return "redirect:/bizInfo/show/{bizInfoId}";
    }

    /**
     * GET 返回所有 tinyBizInfo
     * */
    @GetMapping("/bizInfo/show")
    @ResponseBody
    public List<TinyBizInfoDO> showAllBizInfo(){
        return tinyBIzInfoDAOService.findAllBizInfo();
    }

    /**
     * GET 根据id返回单个tinyBizInfo
     * */
    @GetMapping(value = "/bizInfo/show/{bizInfoId}")
    @ResponseBody
    public TinyBizInfoDO showBizInfoById(@PathVariable("bizInfoId") Integer bizInfoId){
        return tinyBIzInfoDAOService.findBizInfoById(bizInfoId);
    }

    /**
     * GET 返回 tinyBizInfo 删除页面
     * */
    @GetMapping("/bizInfo/delete")
    public String deleteBizInfo(TinyBizInfoDO tinyBizInfoDO){
        return "bizInfo/delete";
    }

    /**
     * POST 删除 tinyBizInfo
     * */
    @PostMapping("/bizInfo/delete")
    public String deleteBizInfoById(TinyBizInfoDO tinyBizInfoDO, RedirectAttributes redirectAttrs) {
        tinyBIzInfoDAOService.deleteBizInfoById(tinyBizInfoDO.getBizInfoId());
        redirectAttrs.addAttribute("bizInfoId", tinyBizInfoDO.getBizInfoId());
        //return "redirect:/bizInfo/delete/{bizInfoId}";
        return "redirect:/bizInfo/successDelete";
    }

    /**
     * GET 返回成功删除 tinyBizInfo 页面
     */
    @GetMapping(value = "/bizInfo/delete/{bizInfoId}")
    @ResponseBody
    public String deleteBizInfoById(@PathVariable("bizInfoId") Integer bizInfoId) {
        return "成功删除 BizInfoID=" + bizInfoId;
    }

    /**
     * GET 返回成功删除 tinyBizInfo 页面
     */
    @GetMapping(value = "/bizInfo/successDelete")
    public String deleteBizInfoById() {
        return "bizInfo/successDelete";
    }
}