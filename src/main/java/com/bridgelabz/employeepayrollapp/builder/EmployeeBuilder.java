package com.bridgelabz.employeepayrollapp.builder;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDto;
import com.bridgelabz.employeepayrollapp.entity.EmployeePayroll;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Purpose: This is a builder class
 *
 * @author: ALISHA BALAMWAR
 * @since:2021-12-13
 */
@Component
public class EmployeeBuilder {

    @Autowired
    private ModelMapper modelMapper;

    /**
     * Purpose: This method is created to copy the properties of POJO class to Entity class
     *
     * @param employeeDto: This is POJO class reference which is source for copying properties
     * @param employeePayroll: This is Entity class reference which is destination to assign properties
     * @return: Returns Object of Employee payroll
     */
    public EmployeePayroll buildEmployeeEntity(EmployeeDto employeeDto, EmployeePayroll employeePayroll) {
        modelMapper.map(employeeDto, employeePayroll);
        return employeePayroll;
    }
}
