/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.java.tiny_reporting.model.enums;

/**
 * @author qinjiasui.qjs
 * @version FlowStatusEnum: FlowStatusEnum.java, v 0.1 2021年05月20日 9:40 上午 qinjiasui.qjs Exp $
 */
public enum FlowStatusEnum {

    /** 运行开始 */
    START("START", "运行开始"),

    /** 运行中 */
    RUNNING("RUNNING", "运行中"),

    /** 运行结束 */
    FINISHED("FINISHED", "运行结束"),

    ;

    /**
     * StatusEnum
     * @param code
     * @param message
     */
    FlowStatusEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    /** 枚举值 */
    private String code;

    /** 枚举描述 */
    private String message;

    /**
     * FlowStatusEnum
     * @param code
     * @return FlowStatusEnum
     */
    public static FlowStatusEnum getByCode(String code) {

        for (FlowStatusEnum statusEnum : values()) {

            if (statusEnum.getCode().equals(code)) {
                return statusEnum;
            }

        }
        return null;
    }

    /**
     * Getter method for property <tt>code</tt>.
     *
     * @return property value of code
     */
    public String getCode() {
        return code;
    }

    /**
     * Getter method for property <tt>message</tt>.
     *
     * @return property value of message
     */
    public String getMessage() {
        return message;
    }
}
