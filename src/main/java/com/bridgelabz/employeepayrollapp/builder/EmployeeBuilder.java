package com.bridgelabz.employeepayrollapp.builder;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDto;
import com.bridgelabz.employeepayrollapp.entity.EmployeePayroll;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeBuilder {

    @Autowired
    private ModelMapper modelMapper;

    public EmployeePayroll buildEmployeeEntity(EmployeeDto employeeDto, EmployeePayroll employeePayroll) {
        modelMapper.map(employeeDto, employeePayroll);
        return employeePayroll;
    }
}
