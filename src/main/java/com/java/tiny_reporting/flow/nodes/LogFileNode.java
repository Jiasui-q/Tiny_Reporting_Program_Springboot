/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.java.tiny_reporting.flow.nodes;

import com.java.tiny_reporting.service.LogService;
import com.java.tiny_reporting.service.impl.LogServiceImpl;
import com.java.tiny_reporting.utils.LogGenerator;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author qinjiasui.qjs
 * @version LogFileNode: LogFileNode.java, v 0.1 2021年05月17日 下午3:17 qinjiasui.qjs Exp $
 */
@Component
public class LogFileNode implements Node{
    private String nodeName;
    private String srcFileDir = "src/data/split_files";

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public void execute(){
        LogService logService = new LogServiceImpl();
        logService.prepareLogFileFromDir(srcFileDir);
    }
}
