package com.pjariwala.chatter.services.impl;

import com.pjariwala.chatter.exceptions.InvalidUserException;
import com.pjariwala.chatter.models.User;
import com.pjariwala.chatter.repositories.UserRepository;
import com.pjariwala.chatter.services.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  @Autowired UserRepository userRepository;

  @Override
  public List<User> findAll() {
    return userRepository.findAll();
  }

  @Override
  public User saveUser(User user) {
    validateUser(user);
    return userRepository.save(user);
  }

  private void validateUser(User user) {
    if (user == null) {
      throw new InvalidUserException("User to be created is invalid.");
    }
    if (user.getPassword() == null || user.getPassword().isEmpty()) {
      throw new InvalidUserException("Password is invalid.");
    }
  }
}
