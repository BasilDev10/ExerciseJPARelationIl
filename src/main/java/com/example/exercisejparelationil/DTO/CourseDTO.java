package com.example.exercisejparelationil.DTO;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CourseDTO {


    private Integer id;

    @NotEmpty(message = "Error: name is null")
    private String name;

    private Integer teacher_id;

}
