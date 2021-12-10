package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDto;
import com.bridgelabz.employeepayrollapp.entity.EmployeePayroll;
import com.bridgelabz.employeepayrollapp.repository.EmployeeRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeePayrollService {
    @Autowired
    EmployeeRepo employeeRepo;
    @Autowired
    private ModelMapper modelMapper;
    private EmployeePayroll employeePayroll;

    public List<EmployeeDto> getListOfAllEmployee() {
        return employeeRepo
                .findAll()
                .stream()
                .map(EmployeePayroll -> modelMapper.map(employeePayroll, EmployeeDto.class))
                .collect(Collectors.toList());
    }
}