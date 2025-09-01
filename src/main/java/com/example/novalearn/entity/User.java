package com.example.novalearn.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
  !User - Student, Teacher, SiteOwner
  *Student Course
  ?Teacher Course
 */

@Table(name = "users")
@Entity
@Getter
@Setter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "user_type")
public abstract class User extends IdClass {

    private String firstName; // *May be many first names
    private String lastName;
    private String email; // 
    @Column(unique = true) // Todo: email must be unique
    private String username; // !Username must be Important 
    private String password; // ?May be many passwords

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
    private Set<Role> roles = new HashSet<>();

    public void addRole(Role role) {
        roles.add(role);
    }
    public User(String firstName, String lastName, String email, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
    }

}
