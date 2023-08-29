package com.zm.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Administrator {

  private long administratorId;
  private String name;
  private String password;
  private String userType;
}
