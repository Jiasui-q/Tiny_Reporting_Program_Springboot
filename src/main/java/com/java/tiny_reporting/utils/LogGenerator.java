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
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        for (int i = 1; i <= 10; i++) {
            String file_path = "src/data/original/2021-05-08_test1kw_" + i + ".txt";
            LogGenerator lg = new LogGenerator();
            lg.generateLogFile(file_path);
        }
    }

    /**
     * 获取并返回文件的md5
     *
     * @param file_path
     * @return String
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    public String getMD5(String file_path) throws IOException, NoSuchAlgorithmException {
        MessageDigest digest = null;
        FileInputStream in = null;
        byte buffer[] = new byte[1024];
        int len;
        digest = MessageDigest.getInstance("MD5");
        File file = new File(file_path);
        if (!file.exists() || !file.isFile()) {
            System.out.println("文件不存在");
            return "None";
        }
        in = new FileInputStream(file);
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
     * @param file_path
     * @return Date
     */
    public Date getCreateTimeDate(String file_path) {
        Date createTimeDate = null;
        Path path = Paths.get(file_path);
        BasicFileAttributeView basicview = Files.getFileAttributeView(path, BasicFileAttributeView.class,
                LinkOption.NOFOLLOW_LINKS);
        BasicFileAttributes attr;
        try {
            attr = basicview.readAttributes();
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
     * @param file_path
     * @return long
     */
    public long getFileSize(String file_path) {
        File file = new File(file_path);
        return file.length();
    }

    /**
     * 获取并返回文件行数
     *
     * @param file_path
     * @return long
     * @throws IOException
     */
    public long getLineNum(String file_path) throws IOException {
        long lineNum = Files.lines(Paths.get(file_path)).count();
        return lineNum;
    }

    /**
     * 返回文件中男人总数
     *
     * @param file_path
     * @return int
     * @throws IOException
     */
    public int getMenNum(String file_path) throws IOException {
        Path filePath = Paths.get(file_path);
        Stream<String> lines = Files.lines(filePath);
        long menNum = lines.skip(1).filter(s -> s.split(", ")[3].equals("男")).count();
        return (int) menNum;

        //        //使用reader一行行读
        //        FileReader read = new FileReader(file_path);
        //        BufferedReader br = new BufferedReader(read);
        //        br.readLine();
        //        String row;
        //        int menNum = 0;
        //        while ((row = br.readLine()) != null) {
        //            String[] info = row.split(", ");
        //            if (info[3].equals("男")) {
        //                menNum++;
        //            }
        //        }
        //        return menNum;
    }

    /**
     * 返回文件中年龄是4的倍数的总和
     *
     * @param file_path
     * @return int
     * @throws IOException
     */
    public int getAge4Num(String file_path) throws IOException {
        Path filePath = Paths.get(file_path);
        Stream<String> lines = Files.lines(filePath);
        /**
         * Step1 跳过第一行
         * Step2 年龄4的倍数
         */
        long age4Num = lines.skip(1)
                .filter(s -> Integer.valueOf(s.split(", ")[4]) % 4 == 0)
                .count();
        return (int) age4Num;

        //        // 使用reader
        //        FileReader read = new FileReader(file_path);
        //        BufferedReader br = new BufferedReader(read);
        //        br.readLine();
        //        String row;
        //        int age4Num = 0;
        //        while ((row = br.readLine()) != null) {
        //            String[] info = row.split(", ");
        //            if (Integer.valueOf(info[4])%4==0) {
        //                age4Num++;
        //            }
        //        }
        //        System.out.println(age4Num);
        //        return age4Num;
    }

    /**
     * 获取并返回此文件所有信息
     *
     * @param file_path
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    public void generateLogFile(String file_path) throws IOException, NoSuchAlgorithmException {
        File f = new File(file_path.split("\\.")[0] + ".log");
        f.createNewFile();
        BufferedWriter out = new BufferedWriter(new FileWriter(f));
        out.write(file_path + "\r\n");
        out.write(getMD5(file_path) + "\r\n");
        out.write(getCreateTimeDate(file_path) + "\r\n");
        out.write(getFileSize(file_path) + "\r\n");
        out.write(getLineNum(file_path) + "\r\n");
        out.write(getMenNum(file_path) + "\r\n");
        out.write(getAge4Num(file_path) + "\r\n");
        out.close();
    }
}

