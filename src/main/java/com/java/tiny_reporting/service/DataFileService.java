/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.java.tiny_reporting.service;

/**
 * I am a DataFileService Interface
 *
 * @author jinyu.qjy
 * @version $Id: DataFileService.java, v 0.1 2021年05月11日 9:47 AM jinyu.qjy Exp $
 */

public interface DataFileService {

    /**
     * 准备一个文件
     *
     * @param totalCount 数据量总条数
     */
    void prepareFileData(Integer totalCount);
}