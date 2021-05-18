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
    private String srcFileDir;
    private String destFileDir;
    private String password;
//    private String srcFileDir = "src/data/zip_files";
//    private String destFileDir = "src/data/encrypt_files";
//    private String password = "123456";

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void execute(){
        CipherService cipherService = new CipherServiceImpl();
        cipherService.encryptFileFromDir(srcFileDir, destFileDir, password);
    }
}
