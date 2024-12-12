package com.example.exercisejparelationil.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Error:name is empty")
    @Size(max = 25, message = "Error: name the length max 25")
    @Column(columnDefinition = "varchar(25) not null")
    private String name;
    @Column(columnDefinition = "int not null")
    private int age;
    @NotEmpty(message = "Error:email is empty")
    @Size(max = 40, message = "Error: email the length max 40")
    @Column(columnDefinition = "varchar(40) not null")
    private String email;
    @Column(columnDefinition = "int not null")
    private Double salary;


    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Address address;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teacher")
    private Set<Course> courses = new HashSet<>();

}