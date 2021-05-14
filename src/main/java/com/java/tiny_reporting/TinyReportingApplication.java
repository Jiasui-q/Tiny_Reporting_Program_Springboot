/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.java.tiny_reporting;

import com.java.tiny_reporting.utils.CipherGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.java.tiny_reporting.utils.FileGenerator;
import com.java.tiny_reporting.utils.LogGenerator;
import com.java.tiny_reporting.utils.ZipGenerator;
import java.security.KeyPair;

@SpringBootApplication
public class TinyReportingApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(TinyReportingApplication.class, args);

		// Generate txt files
		String filePath = "src/data/original/2021-05-08_test1kw.txt";
		FileGenerator.createWholeFile(filePath,100);
		FileGenerator.createSplitFile(filePath,10);

		// Generate log files
		String groupFilePath = "";
		for(int i = 1; i <= 10; i++){
			groupFilePath = "src/data/original/2021-05-08_test1kw_" + i + ".txt";
			LogGenerator.generateLogFile(groupFilePath);
		}

		// Generate zip files，打包文件
		String dataDirPath = "src/data/original";
		ZipGenerator.serialZip(dataDirPath);
		// ZipGenerator.parallelZip(dataPath);

		// Generate cipher files, 对称加密
		String destFilePath = "src/data/cipher/2021-05-08_test1kw.bin";
		String decryptFilePath = "src/data/cipher/decryptFile.txt";
		String password = "123456";
		CipherGenerator.encryptFile(filePath, destFilePath, password);
		CipherGenerator.decryptFile(destFilePath, decryptFilePath, password);
		System.out.println("解密文件校验结果：" + LogGenerator.getMD5(decryptFilePath).equals(LogGenerator.getMD5(filePath)));

		// Generate sign，根据证书生成签名
		String keyStoreAlias = "java-and-more"; // 本地密钥库别名
		String keyStorePassword = "miyaoku"; // 本地密钥库密码
		KeyPair keyPair = CipherGenerator.getKeyPair(keyStoreAlias, keyStorePassword);
		byte[] sign = CipherGenerator.sign(filePath, keyPair.getPrivate());
		boolean isValid = CipherGenerator.valid(filePath, keyPair.getPublic(), sign);
		System.out.println("数字签名校验结果：" + isValid);
	}

}
