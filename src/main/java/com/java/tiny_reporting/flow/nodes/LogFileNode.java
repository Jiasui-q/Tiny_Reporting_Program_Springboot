/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.java.tiny_reporting.flow.nodes;

import com.java.tiny_reporting.service.LogService;
import com.java.tiny_reporting.service.impl.LogServiceImpl;
import org.springframework.stereotype.Component;

/**
 * @author qinjiasui.qjs
 * @version LogFileNode: LogFileNode.java, v 0.1 2021年05月17日 下午3:17 qinjiasui.qjs Exp $
 */
@Component
public class LogFileNode implements Node{
    private String nodeName;
    private String srcFileDir;
    private String destFileDir;
//    private String srcFileDir = "src/data/split_files";
//    private String destFileDir = "src/data/log_files";
    @Override
    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public String getSrcFileDir() {
        return srcFileDir;
    }

    public void setSrcFileDir(String srcFileDir) {
        this.srcFileDir = srcFileDir;
    }

    public String getDestFileDir() {
        return destFileDir;
    }

    public void setDestFileDir(String destFileDir) {
        this.destFileDir = destFileDir;
    }

    @Override
    public void execute(){
        LogService logService = new LogServiceImpl();
        logService.prepareLogFileFromDir(srcFileDir, destFileDir);
    }
}
