/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.java.tiny_reporting.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import com.google.common.base.Joiner;
import com.java.tiny_reporting.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
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
     * 生成1kw个随机RandomPerson并写入filePath
     *
     * @param filePath 生成文件名
     * @param totalCount 总生成人数
     * @throws IOException
     */
    public static void createWholeFile(String filePath, int totalCount) throws IOException {
        File wholeFile = new File(filePath);
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
     * 将createAll()生成的file拆分成10个小file，并在每行第一列加入seq编号。
     * 根据每个RandomPerson的年龄进行分类，每个小file名为原file名加"_组号"
     *
     * @param filePath 读取文件名
     * @param groupCount 组个数
     * @throws IOException
     */
    public static void createSplitFile(String filePath, int groupCount) throws IOException {
        List<BufferedWriter> writers = new ArrayList<>(groupCount);
        int[] seqCount = new int[groupCount];
        Arrays.fill(seqCount, 0);
        for (int i = 1; i <= groupCount; i++) {
            File f = new File(filePath.split("\\.")[0] + "_" + i + ".txt");
            f.createNewFile();
            BufferedWriter out = new BufferedWriter(new FileWriter(f));
            writers.add(out);
            out.write("seq, " + systemPropertiesConfig.getTitle() + "\r\n");
        }
        FileReader read = new FileReader(filePath);
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

