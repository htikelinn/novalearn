package com.example.novalearn.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
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
    private String description;
    private int studentCount;
    @Lob
    private byte[] courseImage;

    @CollectionTable(name = "course_lesson")
    @ElementCollection
    private List<CourseLesson> courseLessons = new ArrayList<>();

    @ManyToOne
    private Category category;

    public void addCourseLesson(String lessonName, String lessonLink){
        courseLessons.add(new CourseLesson(lessonName, lessonLink));
    }

}