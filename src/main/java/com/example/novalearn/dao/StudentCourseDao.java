package com.example.novalearn.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.novalearn.entity.StudentCourse;

public interface StudentCourseDao extends JpaRepository<StudentCourse, Integer> {

}
