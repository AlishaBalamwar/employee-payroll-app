package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDto;
import com.bridgelabz.employeepayrollapp.service.EmployeePayrollService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EmployeePayrollControllerTest {

    @InjectMocks
    private EmployeePayrollController employeePayrollController;

    @Mock
    private EmployeePayrollService employeePayrollService;

    @Test
    void givenAListOfEmployees_whenGetAllListOFEmployeeCalled_shouldReturnListOfEmployee() {
        List<EmployeeDto> employeeDtoList = new ArrayList<>();
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmployeeName("Alisha");
        employeeDto.setEmployeeSalary(50000);
        employeeDtoList.add(employeeDto);
        EmployeeDto employeeDto1 = new EmployeeDto();
        employeeDto1.setEmployeeName("Harry");
        employeeDto1.setEmployeeSalary(50000);
        employeeDtoList.add(employeeDto1);
        when(employeePayrollService.getListOfAllEmployee()).thenReturn(employeeDtoList);
        List<EmployeeDto> actualResponse = employeePayrollController.getListOfAllEmployee();
        for (int i = 0; i < actualResponse.size(); i++) {
            assertEquals(employeeDtoList.get(i).getEmployeeName(), actualResponse.get(i).getEmployeeName());
            assertEquals(employeeDtoList.get(i).getEmployeeSalary(), actualResponse.get(i).getEmployeeSalary());
        }
    }
}
