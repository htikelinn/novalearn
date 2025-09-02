package com.example.novalearn.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class CourseLesson extends IdClass {
    private String lessonName;
    private String lessonLink;
    public CourseLesson(String lessonName, String lessonLink) {
        this.lessonName = lessonName;
        this.lessonLink = lessonLink;
    }

}
