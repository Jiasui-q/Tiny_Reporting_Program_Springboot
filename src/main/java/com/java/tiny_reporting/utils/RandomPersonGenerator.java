package com.java.tiny_reporting.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import com.google.common.collect.Lists;
import com.java.tiny_reporting.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RandomPersonGenerator {

    /**
     * 系统参数config
     */
    private static SystemPropertiesConfig systemPropertiesConfig;

    private static Random random = new Random();

    /**
     * 生成单个person以及它的随机信息
     *
     * @return Person
     */
    public static Person createSingleRandomPerson() {
        Person newPerson = new Person();
        newPerson.setId(setRandomId());
        newPerson.setName(setRandomName());
        newPerson.setSex(setRandomSex());
        newPerson.setAge(setRandomAge());
        newPerson.setDesc(setRandomDesc());
        newPerson.setBizDate(setRandomBizDate(newPerson.getAge()));
        newPerson.setNation(setRandomNation());
        newPerson.setPhone(setRandomPhone());
        newPerson.setEmail(setRandomEmail());
        newPerson.setHobbies(setRandomHobbies());
        return newPerson;
    }
    // ～～～～～～～～～～～～～～～～～公有方法～～～～～～～～～～～～～～～～～～～～

    /**
     * 生成一组随机person
     *
     * @param personNum 指定生成人数
     * @return List<Person>
     */
    public static List<Person> createRandomPersonList(int personNum) {
        List<Person> listRandomPerson = Lists.newArrayList();
        for (int i = 0; i < personNum; i++) {
            listRandomPerson.add(createSingleRandomPerson());
        }
        return listRandomPerson;
    }

    /**
     * 随机生成10个字符的Id
     *
     * @return String
     */
    private static String setRandomId() {
        return getRandomString(10, true);
    }

    // ～～～～～～～～～～～～～～～～～私有方法～～～～～～～～～～～～～～～～～～～～

    /**
     * 随机生成姓名，可以重复2-4位
     *
     * @return String
     */
    private static String setRandomName() {
        StringBuffer sb = new StringBuffer();
        int nameLength = random.nextInt(3) + 1;
        for (int i = 0; i < nameLength; i++) {
            int delta = 0x9fa5 - 0x4e00 + 1;
            sb.append((char) (0x4e00 + random.nextInt(delta)));
        }
        return systemPropertiesConfig.getSurname().get(random.nextInt(systemPropertiesConfig.getSurname().size())) + sb.toString();
    }

    /**
     * 随机生成性别，男/女
     *
     * @return String
     */
    private static String setRandomSex() {
        int s_num = random.nextInt(2);
        if (s_num == 0) {
            return "男";
        } else {
            return "女";
        }
    }

    /**
     * 随机生成年龄，0-100之间
     *
     * @return int
     */
    private static int setRandomAge() {
        return random.nextInt(101);
    }

    /**
     * 随机生成20个字符的desc
     *
     * @return String
     */
    private static String setRandomDesc() {
        return getRandomString(20, true);
    }

    /**
     * 根据年龄随机生成生日
     *
     * @return String
     */
    private static String setRandomBizDate(int randomAge) {
        int month = random.nextInt(12) + 1;
        int day = random.nextInt(30) + 1;
        int year = 2021 - randomAge;
        if ((month > 5) || (month == 5 && day >= 7)) {
            year -= 1;
        }
        String date = String.valueOf(year);
        if (month < 10) {
            date += "0";
        }
        date += String.valueOf(month);
        if (day < 10) {
            date += "0";
        }
        date += String.valueOf(day);
        return date;
    }

    /**
     * 随机生成民族
     *
     * @return String
     */
    private static String setRandomNation() {
        return systemPropertiesConfig.getNation().get(random.nextInt(systemPropertiesConfig.getNation().size()));
    }

    /**
     * 随机生成手机号，以1开头的11位数字
     *
     * @return String
     */
    private static String setRandomPhone() {
        return "1" + getRandomString(10, false);
    }

    /**
     * 随机生成10位的qq邮箱号
     *
     * @return String
     */
    private static String setRandomEmail() {
        return getRandomString(10, false) + "@qq.com";
    }

    /**
     * 随机生成一组兴趣爱好
     *
     * @return Set<String>
     */
    private static Set<String> setRandomHobbies() {
        Set<String> hobbyChosen = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            String choice = systemPropertiesConfig.getHobbies().get(random.nextInt(systemPropertiesConfig.getHobbies().size()));
            if (!hobbyChosen.contains(choice)) {
                hobbyChosen.add(choice);
            }
        }
        return hobbyChosen;
    }

    /**
     * 根据特定length长度以及是否包含字母生成随机字符串
     *
     * @param length：指定字符串的长度
     * @param hasChar：含字符为true，只有数字为false
     * @return String
     */
    private static String getRandomString(int length, boolean hasChar) {
        String base = "";
        if (hasChar) {
            base = "abcdefghijklmnopqrstuvwxyz0123456789";
        } else {
            base = "0123456789";
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    @Autowired
    public void init(SystemPropertiesConfig systemPropertiesConfig) {
        RandomPersonGenerator.systemPropertiesConfig = systemPropertiesConfig;
    }

}

