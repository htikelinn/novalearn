package com.example.novalearn.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
public class CourseLesson {
    private String lessonName;
    @Column(columnDefinition = "TEXT")    
    private String lessonLink;
    public CourseLesson(String lessonName, String lessonLink) {
        super();
        this.lessonName = lessonName;
        this.lessonLink = lessonLink;
    }

}
