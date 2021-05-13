/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.java.tiny_reporting.utils;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 配置信息获取
 *
 * @author jinyu.qjy
 * @version $Id: SystemPropertiesConfig.java, v 0.1 2021年05月11日 10:38 PM jinyu.qjy Exp $
 */
@Component
@ConfigurationProperties(prefix = "random-person-info")
public class SystemPropertiesConfig {

    private List<String> surname;
    private List<String> nation;
    private List<String> hobbies;

    /**
     * Getter method for property <tt>surname</tt>.
     *
     * @return property value of surname
     */
    public List<String> getSurname() {
        return surname;
    }

    /**
     * Setter method for property <tt>surname</tt>.
     *
     * @param surname value be assigned to surname
     */
    public void setSurname(List<String> surname) {
        this.surname = surname;
    }

    /**
     * Getter method for property <tt>nation</tt>.
     *
     * @return property value of nation
     */
    public List<String> getNation() {
        return nation;
    }

    /**
     * Setter method for property <tt>nation</tt>.
     *
     * @param nation value be assigned to nation
     */
    public void setNation(List<String> nation) {
        this.nation = nation;
    }

    /**
     * Getter method for property <tt>hobbies</tt>.
     *
     * @return property value of hobbies
     */
    public List<String> getHobbies() {
        return hobbies;
    }

    /**
     * Setter method for property <tt>hobbies</tt>.
     *
     * @param hobbies value be assigned to hobbies
     */
    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }
}