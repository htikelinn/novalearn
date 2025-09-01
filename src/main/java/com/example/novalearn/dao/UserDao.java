package com.example.novalearn.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.novalearn.entity.User;

public interface UserDao extends JpaRepository<User, Long> {

    @Query("""
            SELECT u FROM User u
            WHERE u.username = :userNameOrEmail OR u.email = :userNameOrEmail
            
            """)
    Optional<User> findByUsernameOrEmail(String userNameOrEmail);
    

}
