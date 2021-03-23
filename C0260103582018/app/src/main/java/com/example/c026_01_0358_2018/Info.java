package com.example.c026_01_0358_2018;

import java.io.Serializable;

public class Info implements Serializable {
    private String  name;
    private int age;
    private String gender;
    private String id;
    private String course;
    private String county;
    private String university;

    public Info(String name, int age, String gender, String id, String course, String county, String university) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.id = id;
        this.course = course;
        this.county = county;
        this.university = university;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return ""+age;
    }

    public String getGender() {
        return gender;
    }

    public String getId() {
        return id;
    }

    public String getCourse() {
        return course;
    }

    public String getCounty() {
        return county;
    }

    public String getUniversity() {
        return university;
    }





}
