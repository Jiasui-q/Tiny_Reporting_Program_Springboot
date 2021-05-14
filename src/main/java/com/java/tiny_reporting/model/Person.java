/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.java.tiny_reporting.model;

import java.util.HashSet;
import java.util.Set;

public class Person {
    /**
     * id
     */
    private String id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别（男、女）
     */
    private String sex;

    /**
     * 年龄（0-100)
     */
    private int age;

    /**
     * desc
     */
    private String desc;

    /**
     * 生日日期
     */
    private String bizDate;

    /**
     * 民族
     */
    private String nation;

    /**
     * 电话号码
     */
    private String phone;

    /**
     * qq邮箱
     */
    private String email;

    /**
     * 爱好
     */
    private Set<String> hobbies = new HashSet<>();

    /**
     * Getter method for property <tt>id</tt>
     * @return property value of id
     */
    public String getId() {
        return id;
    }

    /**
     * Setter method for property <tt>id</tt>.
     *
     * @param id value to be assigned to property id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Getter method for property <tt>name</tt>
     * @return property value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method for property <tt>name</tt>.
     *
     * @param name value to be assigned to property name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter method for property <tt>sex</tt>
     * @return property value of sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * Setter method for property <tt>sex</tt>.
     *
     * @param sex value to be assigned to property sex
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * Getter method for property <tt>age</tt>
     * @return property value of age
     */
    public int getAge() {
        return age;
    }

    /**
     * Setter method for property <tt>age</tt>.
     *
     * @param age value to be assigned to property age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Getter method for property <tt>desc</tt>
     * @return property value of desc
     */
    public String getDesc() {
        return desc;
    }

    /**
     * Setter method for property <tt>desc</tt>.
     *
     * @param desc value to be assigned to property desc
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * Getter method for property <tt>bizDate</tt>
     * @return property value of bizDate
     */
    public String getBizDate() {
        return bizDate;
    }

    /**
     * Setter method for property <tt>bizDate</tt>.
     *
     * @param bizDate value to be assigned to property bizDate
     */
    public void setBizDate(String bizDate) {
        this.bizDate = bizDate;
    }

    /**
     * Getter method for property <tt>nation</tt>
     * @return property value of nation
     */
    public String getNation() {
        return nation;
    }

    /**
     * Setter method for property <tt>nation</tt>.
     *
     * @param nation value to be assigned to property nation
     */
    public void setNation(String nation) {
        this.nation = nation;
    }

    /**
     * Getter method for property <tt>phone</tt>
     * @return property value of phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Setter method for property <tt>phone</tt>.
     *
     * @param phone value to be assigned to property phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Getter method for property <tt>email</tt>
     * @return property value of email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter method for property <tt>email</tt>.
     *
     * @param email value to be assigned to property email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Getter method for property <tt>hobbies</tt>
     * @return property value of hobbies
     */
    public Set<String> getHobbies() {
        return hobbies;
    }

    /**
     * Setter method for property <tt>hobbies</tt>.
     *
     * @param hobbies value to be assigned to property hobbies
     */
    public void setHobbies(Set<String> hobbies) {
        this.hobbies = hobbies;
    }
}
