package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDto;
import com.bridgelabz.employeepayrollapp.service.EmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class EmployeePayrollController {

    @Autowired
    private EmployeePayrollService employeePayrollService;

    @GetMapping(value = "/employee")
    public List<EmployeeDto> getListOfAllEmployee() {
        return employeePayrollService.getListOfAllEmployee();
    }

    @PostMapping(value = "/employee")
    public String addEmployee(@Valid @RequestBody EmployeeDto employeeDto) {
        return employeePayrollService.addEmployee(employeeDto);
    }

    @DeleteMapping("/employee/{id}")
    public String deleteEmployee(@PathVariable int id) {
        return employeePayrollService.deleteEmployee(id);
    }

}
