/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.java.tiny_reporting.dal.dataobject;

import java.util.Date;

/**
 * @author qinjiasui.qjs
 * @version TinyFlowConfig: TinyFlowConfig.java, v 0.1 2021年05月19日 1:36 下午 qinjiasui.qjs Exp $
 */

public class TinyFlowConfigDO {

    /**
     * This property corresponds to db column <tt>config_id</tt>.
     */
    private Integer configId;

    /**
     * This property corresponds to db column <tt>biz_info_id</tt>.
     */
    private Integer bizInfoId;

    /**
     * This property corresponds to db column <tt>json_config</tt>.
     */
    private String jsonConfig;

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
     * Getter method for property <tt>configId</tt>.
     *
     * @return property value of configId
     */
    public Integer getConfigId() {
        return configId;
    }

    /**
     * Setter method for property <tt>configId</tt>.
     *
     * @param configId value to be assigned to property configId
     */
    public void setConfigId(Integer configId) {
        this.configId = configId;
    }

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
     * Getter method for property <tt>gmtModified</tt>.
     *
     * @return property value of gmtModified
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     * Setter method for property <tt>configId</tt>.
     *
     * @param gmtModified value to be assigned to property gmtModified
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * Getter method for property <tt>jsonConfig</tt>.
     *
     * @return property value of jsonConfig
     */
    public String getJsonConfig() {
        return jsonConfig;
    }

    /**
     * Setter method for property <tt>jsonConfig</tt>.
     *
     * @param jsonConfig value to be assigned to property jsonConfig
     */
    public void setJsonConfig(String jsonConfig) {
        this.jsonConfig = jsonConfig;
    }

    /**
     * 打印每个属性值
     * @return
     */
    @Override
    public String toString(){
        return "configId: " + getConfigId() + ", bizInfoId: " + getBizInfoId()
                + ", gmtCreate: " + getGmtCreate() + ", gmtModified: " + getGmtModified()
                + ", jsonConfig: " + getJsonConfig();
    }
}
