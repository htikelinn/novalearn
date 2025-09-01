package com.example.novalearn.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@DiscriminatorValue("TEACHER")
public class Teacher extends User{

    @CollectionTable(name = "teacher_qualifiation")
    @ElementCollection
    private List<String> qualifiations = new ArrayList<>();

    private BigDecimal netWorth;
    public void addQualification(String qualification) {
        qualifiations.add(qualification);
    }
    public Teacher(String firstName, String lastName, String email, String username, String password,
            BigDecimal netWorth) {
        super(firstName, lastName, email, username, password);
        this.netWorth = netWorth;
    }


}
