package com.pjariwala.chatter.mapper;

import com.pjariwala.chatter.dtos.UserDto;
import com.pjariwala.chatter.models.User;
import java.util.List;

public class UserMapper {

  public static UserDto toUserDto(User user) {
    UserDto userDto = new UserDto();
    userDto.setId(user.getId());
    userDto.setUsername(user.getUsername());
    userDto.setEmail(user.getEmail());
    userDto.setName(user.getName());
    userDto.setStatus(user.getStatus());
    userDto.setCreatedAt(user.getCreatedAt());
    userDto.setUpdatedAt(user.getUpdatedAt());
    return userDto;
  }

  public static List<UserDto> toUserDtos(List<User> users) {
    return users.stream().map(UserMapper::toUserDto).toList();
  }
}
