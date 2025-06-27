package com.sssp.crudop.DTO;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.PrivateKey;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CodemeganDTO {

@NotBlank(message = "Name Should not be Empty")
    private String Name;
@Min(value = 14 , message = "Age must greater ther 14 + age to access site")
    private int Age;
    @NotBlank(message = "Address should not be blank")
    private String Address;
@NotBlank(message = "Number should not be blank")
    private String Mobile;


}
