package com.example.novalearn.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@DiscriminatorValue("STUDENT")
public class Student extends User{
    private int discountPoints;

    @Enumerated(EnumType.STRING)
    private Education education;

    @CollectionTable(name = "completed_course")
    @ElementCollection // ? Use for weak relationship
    private List<String> completedCourse = new ArrayList<>();

    public void addCompletesCourse(String completeCourse) {
        completedCourse.add(completeCourse);
    }

    public Student(String firstName, String lastName, String email, String username, String password,
            Education education) {
        super(firstName, lastName, email, username, password);
        this.education = education;
    }



// @param mapKeyColumn


}
