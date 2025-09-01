package com.example.novalearn.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.novalearn.entity.Teacher;

public interface TeacherDao extends JpaRepository<Teacher, Long> {

}
