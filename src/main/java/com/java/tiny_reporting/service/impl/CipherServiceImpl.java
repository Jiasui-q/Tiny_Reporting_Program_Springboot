/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.java.tiny_reporting.service.impl;

import com.java.tiny_reporting.service.CipherService;
import com.java.tiny_reporting.utils.CipherGenerator;
import com.java.tiny_reporting.utils.logger.LogUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author qinjiasui.qjs
 * @version CipherService: CipherServiceImpl.java, v 0.1 2021年05月17日 下午4:25 qinjiasui.qjs Exp $
 */
@Service
public class CipherServiceImpl implements CipherService {

    /**
     * LOGGER
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(CipherService.class);

    /**
     * 加密文件
     *
     * @param srcFilePath 要加密的文件路径
     * @param destFileDir 加密后存放的dir
     * @param password 自定义密码字符串
     */
    @Override
    public void encryptFile(String srcFilePath, String destFileDir, String password) {
        try {
            CipherGenerator.encryptFile(srcFilePath, destFileDir, password);
        } catch (Throwable e) {
            LogUtil.error(LOGGER, e, "文件加密出现错误, 加密文件{0}", srcFilePath);
        }
    }

    /**
     * 解密文件
     *
     * @param srcFilePath 要解密的文件路径
     * @param destFileDir 解密后存放的dir
     * @param password 自定义密码字符串
     */
    @Override
    public void decryptFile(String srcFilePath, String destFileDir, String password) {
        try {
            CipherGenerator.encryptFile(srcFilePath, destFileDir, password);
        } catch (Throwable e) {
            LogUtil.error(LOGGER, e, "文件解密出现错误, 解密文件{0}", srcFilePath);
        }
    }

    /**
     * 为dir下所以文件加密
     *
     * @param srcFileDir 要加密的文件所在dir
     * @param destFileDir 加密后存放的dir
     * @param password 自定义密码字符串
     */
    @Override
    public void encryptFileFromDir(String srcFileDir, String destFileDir, String password){
        File files = new File(srcFileDir);
        ExecutorService es = Executors.newFixedThreadPool(10);
        for (File file : files.listFiles()) {
            Runnable task = ()->{
                try {
                    CipherGenerator.encryptFile(file.getAbsolutePath(), destFileDir, password);
                } catch (Throwable e) {
                    LogUtil.error(LOGGER, e, "文件加密出现错误, 加密文件{0}", file.getAbsolutePath());
                }
            };
            es.submit(task);
        }
    }

    /**
     * 为dir下所以文件解密
     *
     * @param srcFileDir 要解密的文件所在dir
     * @param destFileDir 解密后存放的dir
     * @param password 自定义密码字符串
     */
    @Override
    public void decryptFileFromDir(String srcFileDir, String destFileDir, String password) {
        File files = new File(srcFileDir);
        ExecutorService es = Executors.newFixedThreadPool(10);
        for (File file : files.listFiles()) {
            Runnable task = ()->{
                try {
                    CipherGenerator.encryptFile(file.getAbsolutePath(), destFileDir, password);
                } catch (Throwable e) {
                    LogUtil.error(LOGGER, e, "文件解密出现错误, 解密文件{0}", file.getAbsolutePath());
                }
            };
            es.submit(task);
        }
    }
}
