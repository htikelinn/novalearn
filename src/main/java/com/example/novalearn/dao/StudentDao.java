package com.example.novalearn.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.novalearn.entity.Student;

public interface StudentDao extends JpaRepository<Student, Long> {

}
