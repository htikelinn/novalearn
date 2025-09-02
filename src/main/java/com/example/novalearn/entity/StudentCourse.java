package com.example.novalearn.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class StudentCourse extends IdClass{
    private LocalDate enrollDate;
    private int completement;

    @ManyToOne
    private Student student;

    @ManyToOne
    private Course course;
}
