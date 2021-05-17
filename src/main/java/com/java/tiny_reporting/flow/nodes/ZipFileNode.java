/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.java.tiny_reporting.flow.nodes;

import com.java.tiny_reporting.service.DataFileService;
import com.java.tiny_reporting.service.ZipService;
import com.java.tiny_reporting.service.impl.DataFileServiceImpl;
import com.java.tiny_reporting.service.impl.ZipServiceImpl;
import org.springframework.stereotype.Component;

/**
 * @author qinjiasui.qjs
 * @version ZipFileNode: ZipFileNode.java, v 0.1 2021年05月17日 下午4:09 qinjiasui.qjs Exp $
 */
@Component
public class ZipFileNode implements Node{
    private String nodeName;
    private String srcFileDir = "src/data/split_files";
    private String destFileDir = "src/data/zip_files";

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public void execute(){
        ZipService zipService = new ZipServiceImpl();
        zipService.parallelZip(srcFileDir, destFileDir);
    }
}
