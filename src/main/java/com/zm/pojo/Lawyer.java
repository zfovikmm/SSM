package com.zm.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Lawyer {

  private int lawyerId;
  private String name;
  private String password;
  private long age;
  private String contact;
  private String address;
  private String lawFirm;
  private String education;
  private String specialization;
  private LocalDateTime registrationDate;
  private String userType;
}
