package utils;

import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipGenerator {
    /**
     * 将传入的文件打包成zip
     * @param file 需要打包的文件
     * @throws IOException
     */
    private void zipHelp(File file) throws IOException {
        //压缩文件名称
        String[] file_name = file.getName().split("\\.");
        File zipFile = new File("src/data/zip_files/"+file_name[0]+"_"+file_name[1]+".zip");
        //输入文件流
        InputStream input = new FileInputStream(file);
        BufferedInputStream bis = new BufferedInputStream((input));
        //压缩输出流
        ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipFile));
        BufferedOutputStream bos = new BufferedOutputStream(zipOut);
        zipOut.putNextEntry(new ZipEntry(file.getName()));
        byte[] b = new byte[1024];
        while (true) {
            int len = bis.read(b);
            if (len == -1)
                break;
            bos.write(b, 0, len);
        }
        bos.flush();
        zipOut.close();
    }

    /**
     * 串行的将文件打包并计算耗时
     * @param data_path 需要打包的文件所在的data包路径
     * @throws IOException
     */
    public void serialZip(String data_path) throws IOException {
        long start = System.currentTimeMillis();
        File file = new File(data_path);
        File[] files = file.listFiles();
        for (File f : files) {
            zipHelp(f);
        }
        long end = System.currentTimeMillis();
        System.out.println("并行压缩完成，耗时：" + (end - start) + " ms");
    }

    public void parallelZip(String data_path){
        long start = System.currentTimeMillis();
        ExecutorService es = Executors.newFixedThreadPool(5);
        File file = new File(data_path);
        File[] files = file.listFiles();
        for (File f : files) {
            Runnable task = ()->{
                System.out.println(Thread.currentThread().getName()+"创建一个新线程");
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

    public static void main(String[] args) throws IOException {
        String data_path = "src/data/original";
        ZipGenerator zipUtils = new ZipGenerator();
        zipUtils.serialZip(data_path);
        //zipUtils.parallelZip(data_path);
    }
}
