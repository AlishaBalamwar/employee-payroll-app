package com.bridgelabz.employeepayrollapp.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class EmployeeDto {
    @NotNull
    @Size(min = 3, message = "Name should have atleast 3 characters")
    @Pattern(regexp = "[a-zA-Z]+[\\s]?[a-zA-Z]+$", message = "Name only contains alphabets")
    private String employeeName;
    @NotNull
    private long employeeSalary;
}
