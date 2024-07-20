package com.pjariwala.chatter.repositories;

import com.pjariwala.chatter.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {}
