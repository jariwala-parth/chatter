package com.pjariwala.chatter.dtos;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

@Data
@Generated
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
  private Long id;
  private String username;
  private String email;
  private String name;
  private String status;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
}
