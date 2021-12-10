package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDto;
import com.bridgelabz.employeepayrollapp.service.EmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class EmployeePayrollController {

    @Autowired
    private EmployeePayrollService employeePayrollService;

    @GetMapping(value = "/atm")
    public List<EmployeeDto> getListOfAllEmployee() {
        return employeePayrollService.getListOfAllEmployee();
    }
}