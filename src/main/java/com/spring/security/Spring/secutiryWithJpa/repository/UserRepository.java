package com.spring.security.Spring.secutiryWithJpa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.security.Spring.secutiryWithJpa.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
Optional<User> findByUserName(String userName);
}
