/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.java.tiny_reporting.utils.generator;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import com.java.tiny_reporting.model.Person;
import com.java.tiny_reporting.utils.SystemPropertiesConfig;
import org.springframework.beans.factory.annotation.Autowired;

public class RandomPersonGenerator {

    /**
     * 系统参数config
     */
    private static SystemPropertiesConfig systemPropertiesConfig;

    /**
     * Random对象，用于生成随机数
     */
    private static Random random = new Random();

    @Autowired
    public void init(SystemPropertiesConfig systemPropertiesConfig) {
        RandomPersonGenerator.systemPropertiesConfig = systemPropertiesConfig;
    }

    // ～～～～～～～～～～～～～～～～～公有方法～～～～～～～～～～～～～～～～～～～～

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

    // ～～～～～～～～～～～～～～～～～私有方法～～～～～～～～～～～～～～～～～～～～

    /**
     * 随机生成10个字符的Id
     *
     * @return String
     */
    private static String setRandomId() {
        return getRandomString(10, true);
    }

    /**
     * 随机生成姓名，可以重复2-4位
     *
     * @return String
     */
    private static String setRandomName() {
        StringBuffer sb = new StringBuffer();
        int nameLength = random.nextInt(2) + 1;
        for (int i = 0; i < nameLength; i++) {
            int delta = 0x9fa5 - 0x4e00 + 1;
            sb.append((char) (0x4e00 + random.nextInt(delta)));
        }
        return getRandomElement(systemPropertiesConfig.getSurnameList()) + sb.toString();
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
        return getRandomElement(systemPropertiesConfig.getNationList());
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
            String choice = getRandomElement(systemPropertiesConfig.getHobbiesList());
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
        String base = hasChar ? "abcdefghijklmnopqrstuvwxyz0123456789" : "0123456789";
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            sb.append(base.charAt(random.nextInt(base.length())));
        }
        return sb.toString();
    }

    /**
     * 随机取除list中的一个字符串
     *
     * @param list
     * @return String
     */
    private static String getRandomElement(List<String> list) {
        return list.get(random.nextInt(list.size()));
    }

}

