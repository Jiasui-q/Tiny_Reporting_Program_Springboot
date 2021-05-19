/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.java.tiny_reporting.model;

/**
 * @author qinjiasui.qjs
 * @version Status: Status.java, v 0.1 2021年05月19日 8:01 下午 qinjiasui.qjs Exp $
 */
public enum Status {
    START, RUNNING, FINISHED;

    public String getStatus() {
        switch(this) {
            case START:
                return "Start";

            case RUNNING:
                return "Running";

            case FINISHED:
                return "Finished";

            default:
                return null;
        }
    }
}
