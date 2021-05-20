/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.java.tiny_reporting.dal.dataobject;

import java.util.Date;

/**
 * @author qinjiasui.qjs
 * @version TinyFlowInstance: TinyFlowInstance.java, v 0.1 2021年05月19日 1:36 下午 qinjiasui.qjs Exp $
 */
public class TinyFlowInstanceDO {

    /**
     * This property corresponds to db column <tt>flow_id</tt>.
     */
    private Integer flowId;

    /**
     * This property corresponds to db column <tt>config_id</tt>.
     */
    private Integer configId;

    /**
     * This property corresponds to db column <tt>status</tt>.
     */
    private String status;

    /**
     * This property corresponds to db column <tt>curr_node</tt>.
     */
    private String currNode;

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
     * Getter method for property <tt>flowId</tt>.
     *
     * @return property value of flowId
     */
    public Integer getFlowId() {
        return flowId;
    }

    /**
     * Setter method for property <tt>flowId</tt>.
     *
     * @param flowId value to be assigned to property flowId
     */
    public void setFlowId(Integer flowId) {
        this.flowId = flowId;
    }

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
     * Getter method for property <tt>status</tt>.
     *
     * @return property value of status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Setter method for property <tt>status</tt>.
     *
     * @param status value to be assigned to property status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Getter method for property <tt>currNode</tt>.
     *
     * @return property value of currNode
     */
    public String getCurrNode() {
        return currNode;
    }

    /**
     * Setter method for property <tt>currNode</tt>.
     *
     * @param currNode value to be assigned to property currNode
     */
    public void setCurrNode(String currNode) {
        this.currNode = currNode;
    }

    /**
     * Getter method for property <tt>getGmtCreate</tt>.
     *
     * @return property value of getGmtCreate
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
        return "flowId: " + getFlowId() + ", configId: " + getConfigId() + ", status: " + getStatus()
                + ", currNode: " + getCurrNode() + ", gmtCreate: " + getGmtCreate()
                + ", gmtModified: " + getGmtModified();
    }
}
