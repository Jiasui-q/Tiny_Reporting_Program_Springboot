/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.java.tiny_reporting.utils.generator;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import com.google.common.base.Joiner;
import com.java.tiny_reporting.model.Person;
import com.java.tiny_reporting.utils.SystemPropertiesConfig;
import org.springframework.beans.factory.annotation.Autowired;

public class FileGenerator {

    /**
     * 系统参数config
     */
    private static SystemPropertiesConfig systemPropertiesConfig;

    /**
     * 配置系统参数
     */
    @Autowired
    public void init(SystemPropertiesConfig systemPropertiesConfig) {
        FileGenerator.systemPropertiesConfig = systemPropertiesConfig;
    }

    /**
     * 生成指定个随机RandomPerson并写入filePath
     *
     * @param destFilePath 生成文件储存路径
     * @param totalCount 总生成人数
     * @throws IOException
     */
    public static void createWholeFile(String destFilePath, int totalCount) throws IOException {
        File wholeFile = new File(destFilePath);
        wholeFile.createNewFile();
        BufferedWriter out = new BufferedWriter(new FileWriter(wholeFile));
        out.write(systemPropertiesConfig.getTitle() + "\r\n");
        for (int i = 0; i < totalCount; i++) {
            Person newPerson = RandomPersonGenerator.createSingleRandomPerson();
            out.write(Joiner.on(", ").skipNulls().join(newPerson.getId(), newPerson.getName(),
                    newPerson.getSex(), newPerson.getAge(), newPerson.getDesc(), newPerson.getBizDate(),
                    newPerson.getNation(), newPerson.getPhone(), newPerson.getEmail()) + ", " +
                    newPerson.getHobbies().stream().collect(Collectors.joining("|")) + "\r\n");
        }
        out.close();
    }

    /**
     * 将文件拆分，每个小文件最多能有指定个条数
     *
     * @param srcFilePath 数据源文件路径
     * @param destFileDir 拆分文件储存directory
     * @param fileName 拆分文件名
     * @param eachFileCount 每个拆分文件最多条数
     * @throws IOException
     */
    public static void splitFile(String srcFilePath, String destFileDir, String fileName, int eachFileCount) throws IOException {
        FileReader read = new FileReader(srcFilePath);
        BufferedReader br = new BufferedReader(read);
        br.readLine();
        String row;
        int fileNum = 1;
        while ((row = br.readLine()) != null) {
            int seqNum = 1;
            File f = new File(destFileDir + "/" + fileName + "_" + fileNum + ".txt");
            f.createNewFile();
            BufferedWriter out = new BufferedWriter(new FileWriter(f));
            out.write("seq, " + systemPropertiesConfig.getTitle() + "\r\n"
                        + seqNum + ", " + row + "\r\n");
            while ((row = br.readLine()) != null && seqNum <= eachFileCount) {
                seqNum++;
                out.write(seqNum + ", " + row + "\r\n");
            }
            fileNum++;
            out.close();
        }
    }

    /**
     * 将源文件按RandomPerson的年龄拆分成指定个小文件，并在每行第一列加入seq编号
     *
     * @param srcFilePath 数据源文件路径
     * @param destFileDir 拆分文件储存directory
     * @param fileName 拆分文件名
     * @param groupCount 组个数
     * @throws IOException
     */
    public static void splitFileOnAge(String srcFilePath, String destFileDir, String fileName, int groupCount) throws IOException {
        List<BufferedWriter> writers = new ArrayList<>(groupCount);
        int[] seqCount = new int[groupCount];
        Arrays.fill(seqCount, 0);
        for (int i = 1; i <= groupCount; i++) {
            File f = new File(destFileDir + fileName + "_" + i + ".txt");
            f.createNewFile();
            BufferedWriter out = new BufferedWriter(new FileWriter(f));
            writers.add(out);
            out.write("seq, " + systemPropertiesConfig.getTitle() + "\r\n");
        }
        FileReader read = new FileReader(srcFilePath);
        BufferedReader br = new BufferedReader(read);
        br.readLine();
        String row;
        while ((row = br.readLine()) != null) {
            int group = (int) (Math.ceil(Double.parseDouble(row.split(", ")[3])/groupCount)-1);
            group = group < 0 ? 0: group;
            seqCount[group]++;
            writers.get(group).write(seqCount[group] + ", " + row + "\r\n");

        }
        for (BufferedWriter writer: writers) {
            writer.close();
        }
    }
}

