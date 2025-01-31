package com.pjariwala.chatter.controllers;

import com.pjariwala.chatter.dtos.UserDto;
import com.pjariwala.chatter.models.User;
import com.pjariwala.chatter.services.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@Validated
public class UserController {
  @Autowired UserService userService;

  @GetMapping("/findAll")
  ResponseEntity<List<UserDto>> getUsers() {
    return ResponseEntity.ok(userService.findAll());
  }

  @PostMapping("/saveUser")
  ResponseEntity<UserDto> saveUser(@RequestBody User user) {
    return ResponseEntity.ok(userService.saveUser(user));
  }

  @PatchMapping("/updateUser/{id}")
  ResponseEntity<UserDto> updateUser(@PathVariable Long id, @RequestBody User user) {
    return ResponseEntity.ok(userService.updateUser(id, user));
  }
}
