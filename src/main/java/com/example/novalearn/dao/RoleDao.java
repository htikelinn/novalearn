package com.example.novalearn.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.novalearn.entity.Role;

public interface RoleDao extends JpaRepository<Role, Long> {

}
