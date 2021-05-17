/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.java.tiny_reporting.flow.nodes;

import com.java.tiny_reporting.service.DataFileService;
import com.java.tiny_reporting.service.impl.DataFileServiceImpl;
import org.springframework.stereotype.Component;

/**
 * @author qinjiasui.qjs
 * @version DataFileNode: DataFileNode.java, v 0.1 2021年05月17日 下午2:09 qinjiasui.qjs Exp $
 */
@Component
public class DataFileNode implements Node{
    private String nodeName;
    private String wholeFilePath = "src/data/original/wholeData.txt";
    private String splitFileDir = "src/data/split_files";
    private String splitFileName = "split";
    private int totalCount = 100000000;
    private int eachFileCount = 1000000;

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public void execute(){
        DataFileService dataFileService = new DataFileServiceImpl();
        dataFileService.prepareWholeFile(wholeFilePath, totalCount);
        dataFileService.splitFile(wholeFilePath, splitFileDir, splitFileName, eachFileCount);
    }
}
