/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved
 */

package com.java.tiny_reporting.utils;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 *
 * ToString
 *
 * @author jinyu.qjy
 * @version $Id: ToString.java, v 0.1 2020-01-16 11:01 AM jinyu.qjy Exp $
 */
public class ToString {

    /**
     * To string string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}