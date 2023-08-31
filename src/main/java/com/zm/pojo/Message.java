package com.zm.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {

  private long messageId;
  private long senderId;
  private long recipientId;
  private String content;
  private java.sql.Timestamp timestamp;
  private String title;
  private String type;

}
