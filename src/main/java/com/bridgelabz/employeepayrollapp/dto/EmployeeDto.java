package com.bridgelabz.employeepayrollapp.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
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
    private String name;
    @NotNull
    private long salary;

    @NotNull
    private String profileUrl;
    @NotNull
    private String notes;
    @NotNull
    private String gender;
    private LocalDateTime startDate;
    @NotNull
    private List<String> departmentValue;
}
