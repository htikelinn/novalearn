package com.example.novalearn.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Category extends IdClass {
    private String categoryName;

    public Category(String categoryName) {
        this.categoryName = categoryName;
    }

    @OneToMany(mappedBy = "category", cascade = CascadeType.PERSIST)
    private List<Course> courses = new ArrayList<>();

    public void addCourse(Course course) {
        course.setCategory(this);
        courses.add(course);
    }
}
