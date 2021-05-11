package com.java.tiny_reporting.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.google.common.base.Joiner;
import com.java.tiny_reporting.model.Person;

public class FileGenerator {
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
        writeTitle(out);
        for (int i = 0; i < totalCount; i++) {
            writePersonInfo(out, RandomPersonGenerator.createSingleRandomPerson());
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
        List<BufferedWriter> writers = new ArrayList<>();
        int[] seqCount = new int[groupCount];
        Arrays.fill(seqCount, 0);
        for (int i = 1; i <= groupCount; i++) {
            File f = new File(filePath.split("\\.")[0] + "_" + i + ".txt");
            f.createNewFile();
            BufferedWriter out = new BufferedWriter(new FileWriter(f));
            writers.add(out);
            out.write("seq, ");
            writeTitle(out);
        }
        /**
         * Step1 省略第一行title
         * Step2 获取组号
         * Step3 此组seq号+1
         * Step4 将数据写入此组对应的文件
         */
        Path path = Paths.get(filePath);
        Stream<String> lines = Files.lines(path);
        lines.skip(1)
                .forEach(s -> {
                    int group = (int) (Math.ceil(Double.parseDouble(s.split(", ")[3])/groupCount)-1);
                    if (group == -1){
                        group = 0;
                    }
                    seqCount[group]++;
                    try {
                        writers.get(group).write(seqCount[group] + ", " + s + "\r\n");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
//        FileReader read = new FileReader(filePath);
//        BufferedReader br = new BufferedReader(read);
//        br.readLine();
//        String row;
//        while ((row = br.readLine()) != null) {
//            String[] info = row.split(", ");
//            int age = Integer.valueOf(info[3]);
//            int mult = 100 / groupNum;
//            for (int i = 0; i < groupNum; i++) {
//                int min = 0;
//                int max = 10;
//                int cnt = count[i];
//                if (i != 0) {
//                    min = i * mult + 1;
//                    max = (i + 1) * mult;
//                }
//                if (age >= min && age <= max) {
//                    writers.get(i).write(cnt + ", " + row + "\r\n");
//                    count[i]++;
//                }
//            }
//        }
        for (BufferedWriter writer: writers) {
            writer.close();
        }
    }

    /**
     * 将第一行title写入文件
     *
     * @param out
     * @throws IOException
     */
    private static void writeTitle(BufferedWriter out) throws IOException {
        out.write("id(随机的10位字符串，不能重复), name(中文，可以重复2-4位, sex（随机男、女), "
                + "age(随机0-100，随机排列), desc(随机20个字符), bizDate(以当前时间与age日期对应), nation（民族), "
                + "phone(随机 符合电话要求), email(符合常用的电子邮件@qq)，hobbies(爱好，| 隔开)\r\n");// todo 配置
    }

    /**
     * 将每个RandomPerson的信息写入文件
     *
     * @param out
     * @param newPerson
     * @throws IOException
     */
    private static void writePersonInfo(BufferedWriter out, Person newPerson) throws IOException {
        out.write(Joiner.on(", ").skipNulls().join(newPerson.getId(), newPerson.getName(),
                newPerson.getSex(), newPerson.getAge(), newPerson.getDesc(), newPerson.getBizDate(),
                newPerson.getNation(), newPerson.getPhone(), newPerson.getEmail()));
        out.write(", " + newPerson.getHobbies().stream().collect(Collectors.joining("|")) + "\r\n");
    }
}

