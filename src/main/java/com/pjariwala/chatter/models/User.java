package com.pjariwala.chatter.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "username")
  private String username;

  @Column(name = "password")
  private String password;

  @Column(name = "email")
  private String email;

  @Column(name = "name")
  private String name;

  @Column(name = "status")
  private String status;


  @Column(name = "created_at")
  private LocalDateTime createdAt;


  @Column(name = "updated_at")
  private LocalDateTime updatedAt;

  public LocalDateTime getCreatedAt() {
    if (createdAt == null) {
      createdAt = LocalDateTime.now();
    }
    return createdAt;
  }

  public LocalDateTime getUpdatedAt() {
    if (updatedAt == null) {
      updatedAt = LocalDateTime.now();
    }
    return updatedAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    if (createdAt == null) {
      createdAt = LocalDateTime.now();
    }
    this.createdAt = createdAt;
  }

  public void setUpdatedAt(LocalDateTime updatedAt) {
    if (updatedAt == null) {
      updatedAt = LocalDateTime.now();
    }
    this.updatedAt = updatedAt;
  }
}
