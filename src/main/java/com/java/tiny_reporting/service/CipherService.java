/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.java.tiny_reporting.service;

import org.springframework.stereotype.Service;

/**
 * @author qinjiasui.qjs
 * @version CipherService: CipherService.java, v 0.1 2021年05月17日 下午4:26 qinjiasui.qjs Exp $
 */
public interface CipherService {
    /**
     * 加密文件
     *
     * @param srcFilePath 要加密的文件路径
     * @param destFileDir 加密后存放的dir
     * @param password 自定义密码字符串
     */
    void encryptFile(String srcFilePath, String destFileDir, String password);

    /**
     * 加密文件
     *
     * @param srcFilePath 要解密的文件路径
     * @param destFileDir 解密后存放的dir
     * @param password 自定义密码字符串
     */
    void decryptFile(String srcFilePath, String destFileDir, String password);

    /**
     * 为dir下所以文件加密
     *
     * @param srcFileDir 要加密的文件所在dir
     * @param destFileDir 加密后存放的dir
     * @param password 自定义密码字符串
     */
    void encryptFileFromDir(String srcFileDir, String destFileDir, String password);

    /**
     * 为dir下所以文件解密
     *
     * @param srcFileDir 要解密的文件所在dir
     * @param destFileDir 解密后存放的dir
     * @param password 自定义密码字符串
     */
    void decryptFileFromDir(String srcFileDir, String destFileDir, String password);
}