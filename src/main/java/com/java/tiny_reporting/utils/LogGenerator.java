package com.java.tiny_reporting.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
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
     * @param filePath
     * @return String
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    public static String getMD5(String filePath) throws IOException, NoSuchAlgorithmException {
        File file = new File(filePath);
        if (!file.exists() || !file.isFile()) {
            System.out.println("文件不存在");
            return "None";
        }
        byte buffer[] = new byte[1024];
        int len;
        MessageDigest digest = MessageDigest.getInstance("MD5");
        FileInputStream in = new FileInputStream(file);
        while ((len = in.read(buffer, 0, 1024)) != -1) {
            digest.update(buffer, 0, len);
        }
        in.close();
        BigInteger bigInt = new BigInteger(1, digest.digest());
        return bigInt.toString(16);
    }

    /**
     * 获取并返回文件创建时间
     *
     * @param filePath
     * @return Date
     */
    public static Date getCreateTimeDate(String filePath) {
        Date createTimeDate = null;
        Path path = Paths.get(filePath);
        BasicFileAttributeView basicView = Files.getFileAttributeView(path, BasicFileAttributeView.class,
                LinkOption.NOFOLLOW_LINKS);
        BasicFileAttributes attr;
        try {
            attr = basicView.readAttributes();
            createTimeDate = new Date(attr.creationTime().toMillis());
            return createTimeDate;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取并返回文件大小
     *
     * @param filePath
     * @return long
     */
    public static long getFileSize(String filePath) {
        File file = new File(filePath);
        return file.length();
    }

    /**
     * 获取并返回文件行数
     *
     * @param filePath
     * @return long
     * @throws IOException
     */
    public static long getLineNum(String filePath) throws IOException {
        long lineNum = Files.lines(Paths.get(filePath)).count();
        return lineNum;
    }

    /**
     * 返回文件中男人总数
     *
     * @param filePath
     * @return int
     * @throws IOException
     */
    public static int getMenNum(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        Stream<String> lines = Files.lines(path);
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
     * @param filePath
     * @return int
     * @throws IOException
     */
    public static int getAge4Num(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        Stream<String> lines = Files.lines(path);
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
     * @param filePath
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    public static void generateLogFile(String filePath) throws IOException, NoSuchAlgorithmException {
        File f = new File(filePath.split("\\.")[0] + ".log");
        f.createNewFile();
        BufferedWriter out = new BufferedWriter(new FileWriter(f));
        out.write(filePath + "\r\n");
        out.write(getMD5(filePath) + "\r\n");
        out.write(getCreateTimeDate(filePath) + "\r\n");
        out.write(getFileSize(filePath) + "\r\n");
        out.write(getLineNum(filePath) + "\r\n");
        out.write(getMenNum(filePath) + "\r\n");
        out.write(getAge4Num(filePath) + "\r\n");
        out.close();
    }
}

