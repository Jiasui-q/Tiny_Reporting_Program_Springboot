/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.java.tiny_reporting.flow.nodes;

import com.java.tiny_reporting.service.DataFileService;
import com.java.tiny_reporting.service.impl.DataFileServiceImpl;
import com.java.tiny_reporting.utils.FileGenerator;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author qinjiasui.qjs
 * @version DataFileNode: DataFileNode.java, v 0.1 2021年05月17日 下午2:09 qinjiasui.qjs Exp $
 */
@Component
public class DataFileNode implements Node{
    private String nodeName;
    private String wholeFilePath;
    private String splitFileDir;
    private String splitFileName;
    private int totalCount;
    private int eachFileCount;
//    private String wholeFilePath = "src/data/original/wholeData.txt";
//    private String splitFileDir = "src/data/split_files";
//    private String splitFileName = "split";
//    private int totalCount = 100000000;
//    private int eachFileCount = 1000000;

    @Override
    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public String getWholeFilePath() {
        return wholeFilePath;
    }

    public void setWholeFilePath(String wholeFilePath) {
        this.wholeFilePath = wholeFilePath;
    }

    public String getSplitFileDir() {
        return splitFileDir;
    }

    public void setSplitFileDir(String splitFileDir) {
        this.splitFileDir = splitFileDir;
    }

    public String getSplitFileName() {
        return splitFileName;
    }

    public void setSplitFileName(String splitFileName) {
        this.splitFileName = splitFileName;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getEachFileCount() {
        return eachFileCount;
    }

    public void setEachFileCount(int eachFileCount) {
        this.eachFileCount = eachFileCount;
    }

    @Override
    public void execute(){
        DataFileService dataFileService = new DataFileServiceImpl();
        dataFileService.prepareWholeFile(wholeFilePath, totalCount);
        dataFileService.splitFile(wholeFilePath, splitFileDir, splitFileName, eachFileCount);
    }

    public static void main(String[] args) throws IOException {
        String wholeFilePath = "src/data/original/wholeData.txt";
        FileGenerator.createWholeFile(wholeFilePath, 10);
    }
}
