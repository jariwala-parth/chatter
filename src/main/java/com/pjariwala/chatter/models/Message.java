package com.pjariwala.chatter.models;

import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class Message {

  private String id;
  private String sentBy;
  private String sentTo;
  private String message;
  private LocalDateTime sentAt;
  private boolean isGroupMessage;
}
