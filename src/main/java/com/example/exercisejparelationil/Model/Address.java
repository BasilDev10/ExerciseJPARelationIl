package com.example.exercisejparelationil.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address {

    @Id
    private Integer id;

    @Column(columnDefinition = "varchar(25) not null")
    private String area;
    @Column(columnDefinition = "varchar(25) not null")
    private String street;
    @Column(columnDefinition = "varchar(25) not null")
    private String buildingNumber;

    @OneToOne
    @MapsId
    @JsonIgnore
    private Teacher teacher;
}