/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.java.tiny_reporting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class TinyReportingApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(TinyReportingApplication.class, args);


//		// Generate files
//		FileGenerator.createWholeFile("src/data/original/wholeData.txt",100000000);
//
//      // Split files
//		FileGenerator.splitFile("src/data/original/wholeData.txt", "src/data/split_files", "split",1000000);
//
//		// Generate log files
//		File file = new File("src/data/split_files");
//		File[] files = file.listFiles();
//		int count = 0;
//		for (File f : files) {
//			count++;
//			System.out.println(f.getName());
//			LogGenerator.generateLogFile(f.getAbsolutePath());
//		}
//		System.out.println("为" + count + "个文件生成log");
//
//		// Generate zip files，打包文件
//		ZipGenerator.parallelZip("src/data/split_files", "src/data/zip_files");
//
//		// 加密
//		String encryptFileDir = "src/data/encrypt_files";
//		String password = "123456";
//		CipherGenerator.encryptFile("src/data/split_files/split_1.log", encryptFileDir, password);
//
// 		// 解密
// 		String decryptFileDir = "src/data/decrypt_files";
//		String password = "123456";
//		CipherGenerator.decryptFile("src/data/encrypt_files/split_1_log.bin", decryptFileDir, password);
//		System.out.println("解密文件校验结果：" +
//				LogGenerator.getMD5("src/data/split_files/split_1.log").equals(LogGenerator.getMD5("src/data/decrypt_files/split_1_log.txt")));
//
//		// Generate sign，根据证书生成签名
//		String keyStoreAlias = "java-and-more"; // 本地密钥库别名
//		String keyStorePassword = "miyaoku"; // 本地密钥库密码
//		KeyPair keyPair = CipherGenerator.getKeyPair(keyStoreAlias, keyStorePassword);
//		byte[] sign = CipherGenerator.sign("src/data/split_files/split_1.txt", keyPair.getPrivate());
//		boolean isValid = CipherGenerator.valid("src/data/split_files/split_1.txt", keyPair.getPublic(), sign);
//		System.out.println("数字签名校验结果：" + isValid);
	}

}
