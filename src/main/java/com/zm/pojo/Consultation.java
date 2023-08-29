package com.zm.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Consultation {

  private long consultationId;
  private LocalDateTime requestDate;
  private LocalDateTime responseDate;
  private String status;
  private long delegatorId;
  private long agencyId;
  private String type;
  private String context;

}
