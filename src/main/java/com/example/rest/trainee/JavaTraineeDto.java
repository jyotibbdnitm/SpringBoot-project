package com.example.rest.trainee;


import com.fasterxml.jackson.annotation.JsonIgnore;

public class JavaTraineeDto {
    @JsonIgnore
    private String Id;
    private String name;



    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public Double getFees() {
        return fees;
    }

    public void setFees(Double fees) {
        this.fees = fees;
    }

    private String mobileNo;


    private Double fees;

    public JavaTraineeDto() {
    }
    public JavaTraineeDto(String name, int age, String mobileNo, Double fees) {
        this.name = name;
        this.age = age;
        this.mobileNo = mobileNo;
        this.fees = fees;
    }
}

