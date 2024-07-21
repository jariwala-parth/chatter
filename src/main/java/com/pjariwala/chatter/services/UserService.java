package com.pjariwala.chatter.services;

import com.pjariwala.chatter.dtos.UserDto;
import com.pjariwala.chatter.models.User;
import java.util.List;

public interface UserService {
  List<UserDto> findAll();

  UserDto saveUser(User user);

  UserDto updateUser(Long id, User user);
}
