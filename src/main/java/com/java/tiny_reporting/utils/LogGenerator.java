/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.java.tiny_reporting.utils;

import java.io.*;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.stream.Stream;

public class LogGenerator {

    /**
     * 获取并返回文件的md5
     *
     * @param filePath 数据源文件路径
     * @return String
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    public static String getMD5(String filePath) throws IOException, NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("MD5");
        InputStream input = new FileInputStream(filePath);
        BufferedInputStream bis = new BufferedInputStream((input));
        byte buffer[] = new byte[1024];
        int len;
        while ((len = bis.read(buffer)) != -1) {
            digest.update(buffer, 0, len);
        }
        input.close();
        return new BigInteger(1, digest.digest()).toString(16);
    }

    /**
     * 获取并返回文件创建时间
     *
     * @param filePath 数据源文件路径
     * @return Date
     */
    public static Date getCreateTimeDate(String filePath) {
        try {
            Path path = Paths.get(filePath);
            BasicFileAttributeView basicView = Files.getFileAttributeView(path,
                    BasicFileAttributeView.class, LinkOption.NOFOLLOW_LINKS);
            BasicFileAttributes attr = basicView.readAttributes();
            Date createTimeDate = new Date(attr.creationTime().toMillis());
            return createTimeDate;
        } catch (Exception e) {
            System.out.println("查询文件生成时间失败");
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取并返回文件大小
     *
     * @param filePath 数据源文件路径
     * @return long
     */
    public static long getFileSize(String filePath) {
        return new File(filePath).length();
    }

    /**
     * 获取并返回文件行数
     *
     * @param filePath 数据源文件路径
     * @return long
     * @throws IOException
     */
    public static long getLineNum(String filePath) throws IOException {
        return Files.lines(Paths.get(filePath)).count();
    }

    /**
     * 返回文件中男人总数
     *
     * @param filePath 数据源文件路径
     * @return int
     * @throws IOException
     */
    public static int getMenNum(String filePath) throws IOException {
        Stream<String> lines = Files.lines(Paths.get(filePath));
        /**
         * Step1 跳过第一行
         * Step2 得到男性
         * Step3 个数和
         */
        long menNum = lines.skip(1)
                .filter(s -> s.split(", ")[3].equals("男"))
                .count();
        return (int) menNum;
    }

    /**
     * 返回文件中年龄是4的倍数的总和
     *
     * @param filePath 数据源文件路径
     * @return int
     * @throws IOException
     */
    public static int getAge4Num(String filePath) throws IOException {
        Stream<String> lines = Files.lines(Paths.get(filePath));
        /**
         * Step1 跳过第一行
         * Step2 得到年龄的IntStream
         * Step3 年龄4的倍数
         * Step4 个数和
         */
        long age4Num = lines.skip(1)
                .mapToInt(s -> Integer.valueOf(s.split(", ")[4]))
                .filter(s -> s % 4 == 0)
                .count();
        return (int) age4Num;
    }

    /**
     * 获取并返回此文件所有信息
     *
     * @param srcFilePath 数据源文件路径
     * @param destFileDir log文件储存dir
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    public static void generateLogFile(String srcFilePath, String destFileDir) throws IOException, NoSuchAlgorithmException {
        File srcFile = new File(srcFilePath);
        File logFile = new File(destFileDir + "/" + srcFile.getName().split("\\.")[0] + ".log");
        logFile.createNewFile();
        BufferedWriter out = new BufferedWriter(new FileWriter(logFile));
        out.write(srcFilePath + "\r\n");
        out.write(getMD5(srcFilePath) + "\r\n");
        out.write(getCreateTimeDate(srcFilePath) + "\r\n");
        out.write(getFileSize(srcFilePath) + "\r\n");
        out.write(getLineNum(srcFilePath) + "\r\n");
        out.write(getMenNum(srcFilePath) + "\r\n");
        out.write(getAge4Num(srcFilePath) + "\r\n");
        out.close();
    }
}

