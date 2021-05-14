/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.java.tiny_reporting.utils;

import java.util.List;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "random-person-info")
public class SystemPropertiesConfig {

    /**
     * 中文姓氏列表
     */
    private List<String> surnameList;

    /**
     * 少数名族列表
     */
    private List<String> nationList;

    /**
     * 中文兴趣列表
     */
    private List<String> hobbiesList;

    /**
     * 文件第一行title
     */
    private String title;

    /**
     * Getter method for property <tt>surnameList</tt>.
     *
     * @return property value of surnameList
     */
    public List<String> getSurnameList() {
        return surnameList;
    }

    /**
     * Setter method for property <tt>surnameList</tt>.
     *
     * @param surnameList value be assigned to surnameList
     */
    public void setSurnameList(List<String> surnameList) {
        this.surnameList = surnameList;
    }

    /**
     * Getter method for property <tt>nationList</tt>.
     *
     * @return property value of nationList
     */
    public List<String> getNationList() {
        return nationList;
    }

    /**
     * Setter method for property <tt>nationList</tt>.
     *
     * @param nationList value be assigned to nationList
     */
    public void setNationList(List<String> nationList) {
        this.nationList = nationList;
    }

    /**
     * Getter method for property <tt>hobbiesList</tt>.
     *
     * @return property value of hobbiesList
     */
    public List<String> getHobbiesList() {
        return hobbiesList;
    }

    /**
     * Setter method for property <tt>hobbiesList</tt>.
     *
     * @param hobbiesList value be assigned to hobbiesList
     */
    public void setHobbiesList(List<String> hobbiesList) {
        this.hobbiesList = hobbiesList;
    }

    /**
     * Getter method for property <tt>title</tt>.
     *
     * @return property value of title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Setter method for property <tt>title</tt>.
     *
     * @param title value be assigned to title
     */
    public void setTitle(String title) {
        this.title = title;
    }
}