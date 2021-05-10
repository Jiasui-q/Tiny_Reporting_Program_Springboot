package utils;

import model.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileGenerator {
    /**
     * 生成1kw个随机RandomPerson并写入"src/data/" + file_name + ".txt"
     * @param file_path 生成文件名
     * @param total_num 总生成人数
     * @throws IOException
     */
    public void createAll(String file_path, int total_num) throws IOException {
        File f_all = new File(file_path);
        f_all.createNewFile();
        BufferedWriter out = new BufferedWriter(new FileWriter(f_all));
        writeTitle(out);
        for(int i = 0; i < total_num; i++){
            RandomPersonGenerator newPerson = new RandomPersonGenerator();
            writeEachInfo(out, newPerson.createSingleRandomPerson());
        }
        out.close();
    }

    /**
     * 将createAll()生成的file拆分成10个小file，并在每行第一列加入seq编号。
     * 根据每个RandomPerson的年龄进行分类，每个小file名为原file名加"_组号"
     * @param file_path 读取文件名
     * @param group_num 组个数
     * @throws IOException
     */
    public void createEach(String file_path, int group_num) throws IOException {
        List<BufferedWriter> writers = new ArrayList<>();
        int[] count = new int[group_num];
        for(int i = 0; i < group_num; i++){
            count[i]=0;
        }
        FileReader read = new FileReader(file_path);
        BufferedReader br = new BufferedReader(read);
        br.readLine();
        String row;
        for(int i = 1; i <= group_num; i++){
            File f = new File(file_path.split("\\.")[0] + "_" + i + ".txt");
            f.createNewFile();
            BufferedWriter out = new BufferedWriter(new FileWriter(f));
            writers.add(out);
            out.write("seq, ");
            writeTitle(out);
        }
        while ((row = br.readLine()) != null) {
            String[] info = row.split(", ");
            int age = Integer.valueOf(info[3]);
            int mult = 100/group_num;
            for(int i = 0; i < group_num; i++){
                int min = 0;
                int max = 10;
                int cnt = count[i];
                if(i!=0){
                    min = i*mult+1;
                    max = (i+1)*mult;
                }
                if(age >= min && age <= max){
                    writers.get(i).write(cnt+", " + row + "\r\n");
                    count[i]++;
                }
            }
        }
        for(BufferedWriter writer: writers){
            writer.close();
        }
    }

    /**
     * 将第一行title写入文件
     * @param out
     * @throws IOException
     */
    private void writeTitle(BufferedWriter out) throws IOException {
        out.write("id（随机的10位字符串，不能重复, name（中文，可以重复2-4位, sex（随机男、女, " +
                "age（随机0-100，随机排列, desc(随机20个字符), bizDate（以当前时间与age日期对应, nation（民族, " +
                "phone(随机 符合电话要求), email(符合常用的电子邮件@qq)，hobbies(爱好，| 隔开)\r\n");
    }

    /**
     * 将每个RandomPerson的信息写入文件
     * @param out
     * @param newPerson
     * @throws IOException
     */
    private void writeEachInfo(BufferedWriter out, Person newPerson) throws IOException {
        out.write(newPerson.getId()+", "+newPerson.getName()+", "+newPerson.getSex()+", "+newPerson.getAge()+", "+newPerson.getDesc()+", "
                +newPerson.getBizDate()+", "+newPerson.getNation()+", "+newPerson.getPhone()+", "+newPerson.getEmail()+", ");
        List<String> hobby_list = new ArrayList<>();
        for(String hobby: newPerson.getHobbies()){
            hobby_list.add(hobby);
        }
        out.write(hobby_list.get(0));
        for(int j = 1; j<hobby_list.size(); j++){
            out.write("|"+hobby_list.get(j));
        }
        out.write("\r\n");
    }

    public static void main(String[] args) throws IOException {
        String file_path = "src/data/original/2021-05-08_test1kw.txt";
        FileGenerator fg = new FileGenerator();
        fg.createAll(file_path,100);
        fg.createEach(file_path,10);
    }
}

