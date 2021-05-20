/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.java.tiny_reporting.dal.dataobject;

import java.util.Date;

/**
 * @author qinjiasui.qjs
 * @version TinyBizInfo: TinyBizInfo.java, v 0.1 2021年05月19日 1:38 下午 qinjiasui.qjs Exp $
 */
public class TinyBizInfoDO {

    /**
     * This property corresponds to db column <tt>biz_info_id</tt>.
     */
    private Integer bizInfoId;

    /**
     * This property corresponds to db column <tt>biz_name</tt>.
     */
    private String bizName;

    /**
     * This property corresponds to db column <tt>bu</tt>.
     */
    private String bu;

    /**
     * This property corresponds to db column <tt>owner</tt>.
     */
    private String owner;

    /**
     * This property corresponds to db column <tt>description</tt>.
     */
    private String description;

    /**
     * This property corresponds to db column <tt>gmt_create</tt>.
     */
    private Date gmtCreate;

    /**
     * This property corresponds to db column <tt>gmt_modified</tt>.
     */
    private Date gmtModified;

    //========== getters and setters ==========

    /**
     * Getter method for property <tt>bizInfoId</tt>.
     *
     * @return property value of bizInfoId
     */
    public Integer getBizInfoId() {
        return bizInfoId;
    }

    /**
     * Setter method for property <tt>bizInfoId</tt>.
     *
     * @param bizInfoId value to be assigned to property bizInfoId
     */
    public void setBizInfoId(Integer bizInfoId) {
        this.bizInfoId = bizInfoId;
    }

    /**
     * Getter method for property <tt>bizName</tt>.
     *
     * @return property value of bizName
     */
    public String getBizName() {
        return bizName;
    }

    /**
     * Setter method for property <tt>bizName</tt>.
     *
     * @param bizName value to be assigned to property bizName
     */
    public void setBizName(String bizName) {
        this.bizName = bizName;
    }

    /**
     * Getter method for property <tt>bu</tt>.
     *
     * @return property value of bu
     */
    public String getBu() {
        return bu;
    }

    /**
     * Setter method for property <tt>bu</tt>.
     *
     * @param bu value to be assigned to property bu
     */
    public void setBu(String bu) {
        this.bu = bu;
    }

    /**
     * Getter method for property <tt>owner</tt>.
     *
     * @return property value of owner
     */
    public String getOwner() {
        return owner;
    }

    /**
     * Setter method for property <tt>owner</tt>.
     *
     * @param owner value to be assigned to property owner
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }

    /**
     * Getter method for property <tt>description</tt>.
     *
     * @return property value of description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Setter method for property <tt>description</tt>.
     *
     * @param description value to be assigned to property description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Getter method for property <tt>gmtCreate</tt>.
     *
     * @return property value of gmtCreate
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * Setter method for property <tt>gmtCreate</tt>.
     *
     * @param gmtCreate value to be assigned to property gmtCreate
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * Getter method for property <tt>jsonConfig</tt>.
     *
     * @return property value of jsonConfig
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     * Setter method for property <tt>gmtModified</tt>.
     *
     * @param gmtModified value to be assigned to property gmtModified
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * 打印每个属性值
     * @return
     */
    @Override
    public String toString(){
        return "bizInfoId: " + getBizInfoId() + ", bizName: " + getBizName() + ", bu: " + getBu()
                + ", owner: " + getOwner() + ", description: " + getDescription() + ", gmtCreate: "
                + getGmtCreate() + ", gmtModified: " + getGmtModified();
    }
}
