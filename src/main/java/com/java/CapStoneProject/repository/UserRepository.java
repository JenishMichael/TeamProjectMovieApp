package com.java.CapStoneProject.repository;

import com.java.CapStoneProject.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
}
