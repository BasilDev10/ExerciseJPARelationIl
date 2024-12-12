package com.example.exercisejparelationil.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDTO {
    private Integer teacher_id;

    @NotEmpty(message = "Error: area is empty")
    @Size(max = 25 , message = "Error: area max is 25 length")
    private String area;
    @NotEmpty(message = "Error: street is empty")
    @Size(max = 25 , message = "Error: street max is 25 length")
    private String street;
    @NotEmpty(message = "Error: buildingNumber is empty")
    @Size(max = 25 , message = "Error: buildingNumber max is 25 length")
    private String buildingNumber;

}
