package com.example.rest.trainee;

import jakarta.persistence.*;


@Entity

@Table(name="taineeDetails")

public class JavaTraineeEntity {
   @jakarta.persistence.Id
   @GeneratedValue(strategy = GenerationType.UUID)
   private String Id;
   private String name;



   private int age;



   private String mobileNo;
   private Double fees;

   public String getId() {
      return Id;
   }

   public void setId(String id) {
      Id = id;
   }

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

   public JavaTraineeEntity() {
   }

   public JavaTraineeEntity(String id, String name, int age, String mobileNo, Double fees) {
      Id = id;
      this.name = name;
      this.age = age;
      this.mobileNo = mobileNo;
      this.fees = fees;
   }
}
