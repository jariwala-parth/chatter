package com.pjariwala.chatter.services;

import com.pjariwala.chatter.models.User;

import java.util.List;

public interface UserService {
  List<User> findAll();

  User saveUser(User user);
}
