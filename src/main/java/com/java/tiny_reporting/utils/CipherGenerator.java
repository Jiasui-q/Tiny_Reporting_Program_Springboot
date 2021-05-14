/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.java.tiny_reporting.utils;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.*;
import java.security.cert.CertificateException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * @author qinjiasui.qjs
 * @version CipherGeneretor: CipherGenerator.java, v 0.1 2021年05月14日 上午10:09 qinjiasui.qjs Exp $
 */
public class CipherGenerator {

    /**
     * 对称加密算法
     */
    public static final String SYMMETRIC_KEY_ALGORITHM = "AES";

    /**
     * 非对称加密算法
     */
    public static final String ASYMMETRIC_KEY_ALGORITHM = "RSA";

    /**
     * 数字签名算法
     */
    public static final String SIGN_ALGORITHM = "SHA256withRSA";

    /**
     * 本地密钥库类型
     */
    public static final String KEY_STORE_TYPE = "pkcs12";

    // ～～～～～～～～～～～～～～～～～私有方法～～～～～～～～～～～～～～～～～～～～

    /**
     * 根据模型和密码获取加密cipher
     *
     * @param model 加密模型/解密模型
     * @param password 自定义密码字符串
     * @return Cipher
     */
    private static Cipher getCipher(int model, String password) {
        try {
            //获取加密生成器
            KeyGenerator keyGenerator = KeyGenerator.getInstance(SYMMETRIC_KEY_ALGORITHM);
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            secureRandom.setSeed(password.getBytes());
            keyGenerator.init(128,secureRandom);
            //产生原始对称密钥
            SecretKey originalKey = keyGenerator.generateKey();
            //获得原始对称密钥的字节数组
            byte[] byteKey = originalKey.getEncoded();
            //根据字节数组生成AES密钥
            SecretKey AESKey = new SecretKeySpec(byteKey, SYMMETRIC_KEY_ALGORITHM);
            Cipher cipher=Cipher.getInstance(SYMMETRIC_KEY_ALGORITHM);
            cipher.init(model, AESKey);
            return cipher;
        } catch (NoSuchAlgorithmException e) {
            System.out.println("No key generator algorithm found.");
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            System.out.println("Padding failed when creating cipher.");
            e.printStackTrace();
        } catch (InvalidKeyException e){
            System.out.println("Secrte key is invalid.");
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据加密模型
     *
     * @param password 自定义密码字符串
     * @return Cipher
     */
    private static Cipher getEncryptCipher(String password){
        return getCipher(Cipher.ENCRYPT_MODE, password);
    }

    /**
     * 根据解密模型
     *
     * @param password 自定义密码字符串
     * @return Cipher
     */
    private static Cipher getDecryptCipher(String password){
        return getCipher(Cipher.DECRYPT_MODE, password);
    }

    // ～～～～～～～～～～～～～～～～～公有方法～～～～～～～～～～～～～～～～～～～～

    /**
     * 加密文件
     *
     * @param srcFilePath 要加密的文件路径
     * @param destFilePath 加密后存放的文件路径
     * @param password 自定义密码字符串
     */
    public static void encryptFile(String srcFilePath, String destFilePath, String password) {
        try {
            File destFile = new File(destFilePath);
            destFile.createNewFile();
            InputStream input = new FileInputStream(srcFilePath);
            OutputStream output = new FileOutputStream(destFilePath);
            CipherInputStream cipherInput = new CipherInputStream(input, getEncryptCipher(password));
            byte[] buffer = new byte[1024];
            int len;
            while ((len = cipherInput.read(buffer)) != -1) {
                output.write(buffer, 0, len);
            }
            cipherInput.close();
            output.close();
            input.close();
        } catch (Exception e) {
            System.out.println("加密文件出现异常");
            e.printStackTrace();
        }
    }

    /**
     * 解密文件
     *
     * @param srcFilePath 要解密的文件路径
     * @param destFilePath 解密后存放的文件路径
     * @param password 自定义密码字符串
     */
    public static void decryptFile(String srcFilePath, String destFilePath, String password) {
        try {
            File destFile = new File(destFilePath);
            destFile.createNewFile();
            InputStream input = new FileInputStream(srcFilePath);
            OutputStream output = new FileOutputStream(destFilePath);
            CipherOutputStream cipherOutput = new CipherOutputStream(output, getDecryptCipher(password));
            byte[] buffer = new byte[1024];
            int len;
            while ((len = input.read(buffer)) != -1) {
                cipherOutput.write(buffer, 0, len);
            }
            cipherOutput.close();
            input.close();
            output.close();
        } catch (Exception e) {
            System.out.println("解密文件出现异常");
            e.printStackTrace();
        }
    }

    /**
     * 获取私钥和公钥对
     *
     * @param alias 密钥库别名
     * @param password 密钥库密码
     * @return KeyPair
     */
    public static KeyPair getKeyPair(String alias, String password) {
        try {
            String keyStoreFile = "/tmp/java-and-more.keystore";
            KeyStore keyStore = KeyStore.getInstance(KEY_STORE_TYPE);
            keyStore.load(Files.newInputStream(Paths.get(keyStoreFile)), password.toCharArray());
            Key key = keyStore.getKey(alias, password.toCharArray());
            if (key instanceof PrivateKey) {
                PublicKey publicKey = keyStore.getCertificate(alias).getPublicKey();
                return new KeyPair(publicKey, (PrivateKey) key);
            }
        } catch (UnrecoverableKeyException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyStoreException e) {
            e.printStackTrace();
        } catch (CertificateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 生成文件的数字签名
     *
     * @param filePath 文件路径
     * @param privateKey 私钥
     * @return byte[]
     */
    public static byte[] sign(String filePath, PrivateKey privateKey) throws Exception{
        InputStream input = new FileInputStream(filePath);
        BufferedInputStream bis = new BufferedInputStream((input));
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privateKey.getEncoded());
        KeyFactory keyFactory = KeyFactory.getInstance(ASYMMETRIC_KEY_ALGORITHM);
        PrivateKey privateEncodeKey = keyFactory.generatePrivate(keySpec);
        Signature signature = Signature.getInstance(SIGN_ALGORITHM);
        signature.initSign(privateEncodeKey);
        byte buffer[] = new byte[1024];
        int len;
        while ((len = bis.read(buffer)) != -1) {
            signature.update(buffer, 0, len);
        }
        bis.close();
        return signature.sign();
    }

    /**
     * 根据公钥校验签名
     *
     * @param filePath 文件路径
     * @param publicKey 公钥
     * @param sign 数字签名
     * @return boolean
     */
    public static boolean valid(String filePath, PublicKey publicKey, byte[] sign) throws Exception{
        InputStream input = new FileInputStream(filePath);
        BufferedInputStream bis = new BufferedInputStream((input));
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicKey.getEncoded());
        KeyFactory keyFactory = KeyFactory.getInstance(ASYMMETRIC_KEY_ALGORITHM);
        PublicKey publicEncodeKey = keyFactory.generatePublic(keySpec);
        Signature signature = Signature.getInstance(SIGN_ALGORITHM);
        signature.initVerify(publicEncodeKey);
        byte buffer[] = new byte[1024];
        int len;
        while ((len = bis.read(buffer)) != -1) {
            signature.update(buffer, 0, len);
        }
        return signature.verify(sign);
    }
}
