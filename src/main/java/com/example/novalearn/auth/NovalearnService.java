package com.example.novalearn.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.novalearn.dao.CategoryDao;
import com.example.novalearn.dao.CourseDao;
import com.example.novalearn.dao.TeacherDao;

@Service
public class NovalearnService {

    @Autowired
    private CategoryDao categoryDao;
    @Autowired
    private CourseDao courseDao;
    @Autowired
    private TeacherDao teacherDao;


    // create course
    // student enroll course

}
