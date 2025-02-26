package com.example.rest.trainee;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class JavaTraineeDto {
    @JsonIgnore
    private String Id;
    @NotEmpty(message = "name should be present")
    @Size(min = 3, max = 15, message = "minimum character should be 3 or maxmimum charcater should be 15")
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

