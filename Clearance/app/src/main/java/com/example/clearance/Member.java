package com.example.clearance;

public class Member {
    private  String name;
    private String reg_no;
    private String course;
    private Integer year_of_study;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReg_no() {
        return reg_no;
    }

    public void setReg_no(String reg_no) {
        this.reg_no = reg_no;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Integer getYear_of_study() {
        return year_of_study;
    }

    public void setYear_of_study(Integer year_of_study) {
        this.year_of_study = year_of_study;
    }

    public Member() {

    }
}
