package com.pjariwala.chatter.services;

import com.pjariwala.chatter.models.Users;
import java.util.List;

public interface UserService {
  List<Users> findAll();

  Users saveUser(Users user);
}
