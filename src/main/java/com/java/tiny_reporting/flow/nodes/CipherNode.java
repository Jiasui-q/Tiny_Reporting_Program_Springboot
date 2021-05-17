/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.java.tiny_reporting.flow.nodes;

import com.java.tiny_reporting.service.CipherService;
import com.java.tiny_reporting.service.impl.CipherServiceImpl;
import org.springframework.stereotype.Component;

/**
 * @author qinjiasui.qjs
 * @version CipherNode: CipherNode.java, v 0.1 2021年05月17日 下午5:09 qinjiasui.qjs Exp $
 */
@Component
public class CipherNode implements Node{
    private String nodeName;
    private String srcFileDir = "src/data/zip_files";
    private String encryptFileDir = "src/data/encrypt_files";
    private String password = "123456";

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public void execute(){
        CipherService cipherService = new CipherServiceImpl();
        cipherService.encryptFileFromDir(srcFileDir, encryptFileDir, password);
    }
}
