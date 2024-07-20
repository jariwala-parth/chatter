package com.pjariwala.chatter.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Document(collection = "users")
public class User {
  @Id @JsonIgnore private String id;
  private String username;
  private String password;
  private String email;
}
