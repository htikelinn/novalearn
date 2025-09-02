package com.example.novalearn.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.novalearn.entity.Course;

public interface CourseDao extends JpaRepository<Course, Integer> {

}
