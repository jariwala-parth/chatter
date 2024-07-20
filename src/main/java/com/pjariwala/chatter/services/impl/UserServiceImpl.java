package com.pjariwala.chatter.services.impl;

import com.pjariwala.chatter.exceptions.InvalidUserException;
import com.pjariwala.chatter.models.Users;
import com.pjariwala.chatter.repositories.UserRepository;
import com.pjariwala.chatter.repositories.UsersRepository;
import com.pjariwala.chatter.services.UserService;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  UsersRepository userRepository;

  @Override
  public List<Users> findAll() {
    return userRepository.findAll();
  }

  @Override
  public Users saveUser(Users user) {
    validateUser(user);
    return userRepository.save(user);
  }

  private void validateUser(Users user) {
    if (user == null) {
      throw new InvalidUserException("Users to be created is invalid.");
    }
    if (user.getPassword() == null || user.getPassword().isEmpty()) {
      throw new InvalidUserException("Password is invalid.");
    }
    user.setCreatedAt(LocalDateTime.now());
    user.setUpdatedAt(LocalDateTime.now());
  }
}
