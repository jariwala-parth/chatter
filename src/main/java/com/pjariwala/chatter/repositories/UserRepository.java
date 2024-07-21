package com.pjariwala.chatter.repositories;

import com.pjariwala.chatter.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {}
