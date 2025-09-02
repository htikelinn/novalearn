package com.example.novalearn.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Setter
@Getter
@NoArgsConstructor
public class Course extends IdClass 
{
    private String title;
    private BigDecimal fees;
    @Column(columnDefinition = "TEXT")
    private String description;
    private int studentCount;
    @Lob
    private byte[] courseImage;

    @CollectionTable(name = "course_lesson")
    @ElementCollection
    private List<CourseLesson> courseLessons = new ArrayList<>();

    @ManyToOne
    private Category category;


    @OneToMany(mappedBy = "course",cascade = CascadeType.PERSIST)
    private List<StudentCourse> studentCourses = new ArrayList<>();

    @ManyToOne
    private Teacher teacher;

    public void addCourseLesson(String lessonName, String lessonLink){
        courseLessons.add(new CourseLesson(lessonName, lessonLink));
    }

    public void addStudentCourse(StudentCourse studentCourse) {
        studentCourse.setCourse(this);
        studentCourses.add(studentCourse);
    }
}