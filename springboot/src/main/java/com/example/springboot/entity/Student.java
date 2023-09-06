package com.example.springboot.entity;

import jdk.jfr.MetadataDefinition;
import lombok.Data;

/**
 * @BelongsProject: student-manager
 * @BelongsPackage: com.example.springboot.entity
 * @Author: yanhongwei
 * @CreateTime: 2023-06-29  11:31
 * @Description: TODO
 * @Version: 1.0
 */

@Data
public class Student {
    private String sno;
    private int age;
    private String name;
    private String sex;
    private String dept;
    private String acad;
    private Integer math;
    private Integer english;
    private Integer physics;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getAcad() {
        return acad;
    }

    public void setAcad(String acad) {
        this.acad = acad;
    }

    public Integer getMath() {
        return math;
    }

    public void setMath(Integer math) {
        this.math = math;
    }

    public Integer getEnglish() {
        return english;
    }

    public void setEnglish(Integer english) {
        this.english = english;
    }

    public Integer getPhysics() {
        return physics;
    }

    public void setPhysics(Integer physics) {
        this.physics = physics;
    }

}
