package utils;

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
import java.util.Arrays;
import java.util.Date;
import java.util.stream.Stream;

public class LogGenerator {
    /**
     * 获取并返回文件的md5
     * @param file_path
     * @throws IOException
     * @throws NoSuchAlgorithmException
     * @return String
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
     */
    public Date getCreateTimeDate(String file_path){
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
     */
    public long getFileSize(String file_path) {
        File file = new File(file_path);
        return file.length();
    }

    /**
     * 获取并返回文件行数
     * @throws IOException
     */
    public long getLineNum(String file_path) throws IOException {
        long lineNum = Files.lines(Paths.get(file_path)).count();
        return lineNum;
    }

    /**
     * 返回文件中男人总数
     * @throws IOException
     */
    public int getMenNum(String file_path) throws IOException {
        Path filePath = Paths.get(file_path);
        Stream<String> lines = Files.lines(filePath);
        long menNum = lines.filter(s -> s.split(", ")[3].equals("男")).count();
        //lines.filter(s -> s.split(", ")[0].equals("0")).forEach(System.out::println);
        //lines.map(s -> s.split(", ").toString()).forEach(System.out::println);
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
//        System.out.println(menNum);
        return (int)menNum;
    }

    /**
     * 返回文件中年龄是4的倍数的总和
     * @throws IOException
     */
    public int getAge4Num(String file_path) throws IOException {
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
//        return age4Num;

        Path filePath = Paths.get(file_path);
        Stream<String> lines = Files.lines(filePath);
        lines.filter(s -> Integer.valueOf(s.split(", ")[4])%4==0).forEach(System.out::println);
        return 0;
    }

    /**
     * 获取并返回此文件所有信息
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    public void generateLogFile(String file_path) throws IOException, NoSuchAlgorithmException {
        File f = new File(file_path.split("\\.")[0]+".log");
        f.createNewFile();
        BufferedWriter out = new BufferedWriter(new FileWriter(f));
        out.write(file_path+"\r\n");
        out.write(getMD5(file_path)+"\r\n");
        out.write(getCreateTimeDate(file_path)+"\r\n");
        out.write(getFileSize(file_path)+"\r\n");
        out.write(getLineNum(file_path)+"\r\n");
        out.write(getMenNum(file_path)+"\r\n");
        out.write(getAge4Num(file_path)+"\r\n");
        out.close();
    }

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
//        for(int i = 1; i <= 10; i++){
//            String file_path = "src/data/original/2021-05-08_test1kw_" + i + ".txt";
//            LogGenerator lg = new LogGenerator();
//            lg.generateLogFile(file_path);
//        }
        String file_path = "src/data/original/2021-05-08_test1kw_1.txt";
        LogGenerator lg = new LogGenerator();
        lg.getMenNum(file_path);
    }
}

