package com.bridgelabz.employeepayrollapp.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Purpose: To invoke data from client
 *
 * @author : ALISHA BALAMWAR
 * @since:2021-12-13
 */
@Data
public class EmployeeDto {
    @NotNull
    @Size(min = 3, message = "Name should have atleast 3 characters")
    @Pattern(regexp = "[a-zA-Z]+[\\s]?[a-zA-Z]+$", message = "Name only contains alphabets")
    private String employeeName;
    @NotNull
    private long employeeSalary;
    @NotNull
    private String gender;
    @NotNull
    private List<String> departments;
}
