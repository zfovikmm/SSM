package com.zm.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Delegator {

  private long delegatorId;
  private String dename;
  private String depassword;
  private String email;
  private String phone;
  private String address;
  private String sex;
  private long consultationId;
  private long agencyId;
  private String userType;
}
