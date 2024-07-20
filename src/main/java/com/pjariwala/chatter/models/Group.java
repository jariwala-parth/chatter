package com.pjariwala.chatter.models;

import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class Group {

  private String id;
  private String name;
  private String description;
  private String createdBy;
  private String updatedBy;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
}
