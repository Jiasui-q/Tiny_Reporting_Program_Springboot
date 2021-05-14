/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.java.tiny_reporting.utils;

import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipGenerator {

    // ～～～～～～～～～～～～～～～～～公有方法～～～～～～～～～～～～～～～～～～～～

    /**
     * 串行的将文件打包并计算耗时
     * 
     * @param dataPath 需要打包的文件所在的data包路径
     * @throws IOException
     */
    public static void serialZip(String dataPath) throws IOException {
        long start = System.currentTimeMillis();
        File file = new File(dataPath);
        File[] files = file.listFiles();
        for (File f : files) {
            zipHelp(f);
        }
        long end = System.currentTimeMillis();
        System.out.println("并行压缩完成，耗时：" + (end - start) + " ms");
    }

    /**
     * 并行的将文件打包并计算耗时
     * 
     * @param dataPath 需要打包的文件所在的data包路径
     */
    public static void parallelZip(String dataPath){
        long start = System.currentTimeMillis();
        ExecutorService es = Executors.newFixedThreadPool(5);
        File file = new File(dataPath);
        File[] files = file.listFiles();
        for (File f : files) {
            Runnable task = ()->{
                try {
                    zipHelp(f);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            };
            es.submit(task);
        }
        long end = System.currentTimeMillis();
        System.out.println("串行压缩完成，耗时：" + (end - start) + " ms");
    }

    // ～～～～～～～～～～～～～～～～～私有方法～～～～～～～～～～～～～～～～～～～～

    /**
     * 将传入的文件打包成zip
     *
     * @param file 需要打包的文件
     * @throws IOException
     */
    private static void zipHelp(File file) throws IOException {
        //压缩文件名称
        String[] fileName = file.getName().split("\\.");
        File zipFile = new File("src/data/zip_files/"+fileName[0]+"_"+fileName[1]+".zip");
        //输入文件流
        InputStream input = new FileInputStream(file);
        BufferedInputStream bis = new BufferedInputStream((input));
        //压缩输出流
        ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipFile));
        BufferedOutputStream bos = new BufferedOutputStream(zipOut);
        zipOut.putNextEntry(new ZipEntry(file.getName()));
        byte[] b = new byte[1024];
        int len;
        while ((len = bis.read(b)) != -1) {
            bos.write(b, 0, len);
        }
        bos.flush();
        zipOut.close();
    }
}
