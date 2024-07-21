package com.pjariwala.chatter.services.impl;

import com.pjariwala.chatter.dtos.UserDto;
import com.pjariwala.chatter.exceptions.InvalidUserException;
import com.pjariwala.chatter.mapper.UserMapper;
import com.pjariwala.chatter.models.User;
import com.pjariwala.chatter.repositories.UserRepository;
import com.pjariwala.chatter.services.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  @Autowired UserRepository userRepository;
  @Autowired PasswordEncoder passwordEncoder;

  @Override
  public List<UserDto> findAll() {
    return UserMapper.toUserDtos(userRepository.findAll());
  }

  @Override
  public UserDto saveUser(User user) {
    validateUser(user);
    return UserMapper.toUserDto(userRepository.save(user));
  }

  @Override
  public UserDto updateUser(Long id, User user) {
    User existingUser = userRepository.findById(id).orElse(null);
    if (existingUser == null) {
      throw new InvalidUserException(
          "User does not Exist.", HttpStatus.NOT_FOUND.getReasonPhrase());
    }
    user.setId(id);
    user.setCreatedAt(existingUser.getCreatedAt());

    validateUser(user);
    return UserMapper.toUserDto(userRepository.save(user));
  }

  private void validateUser(User user) {
    if (user == null) {
      throw new InvalidUserException("User to be created is invalid.");
    }
    if (user.getPassword() == null || user.getPassword().isEmpty()) {
      throw new InvalidUserException("Password is invalid.");
    } else {
      user.setPassword(passwordEncoder.encode(user.getPassword()));
    }
  }
}
