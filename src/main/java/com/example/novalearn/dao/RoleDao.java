package com.example.novalearn.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.novalearn.entity.Role;

public interface RoleDao extends JpaRepository<Role, Long> {
    Optional<Role> findByRoleName(String roleName);

}
