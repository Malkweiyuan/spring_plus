package com.example.springplus.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person {
    private String name;  // 姓名
    private int salary; // 薪资
    private int age; // 年龄
    private String sex; //性别

    public Person(String name, int salary, int age,String sex) {
        this.name = name;
        this.salary = salary;
        this.age = age;
        this.sex = sex;

    }
}
