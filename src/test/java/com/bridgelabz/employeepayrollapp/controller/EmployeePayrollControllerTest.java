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
        employeeDto.setDepartments(List.of("It"));
        employeeDto.setGender("female");
        employeeDtoList.add(employeeDto);
        EmployeeDto employeeDto1 = new EmployeeDto();
        employeeDto1.setEmployeeName("Harry");
        employeeDto1.setEmployeeSalary(50000);
        employeeDto1.setDepartments(List.of("It"));
        employeeDto1.setGender("male");
        employeeDtoList.add(employeeDto1);
        when(employeePayrollService.getListOfAllEmployee()).thenReturn(employeeDtoList);
        List<EmployeeDto> actualResponse = employeePayrollController.getListOfAllEmployee();
        for (int i = 0; i < actualResponse.size(); i++) {
            assertEquals(employeeDtoList.get(i).getEmployeeName(), actualResponse.get(i).getEmployeeName());
            assertEquals(employeeDtoList.get(i).getEmployeeSalary(), actualResponse.get(i).getEmployeeSalary());
        }
    }

    @Test
    void givenAEmployeeDetails_whenAddEmployeeDetailsCalled_shouldAddTheEmployee() {
        String successString = "Employee added successfully";
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmployeeName("Alisha");
        employeeDto.setEmployeeSalary(50000);
        employeeDto.setDepartments(List.of("It"));
        employeeDto.setGender("female");
        when(employeePayrollService.addEmployee(employeeDto)).thenReturn(successString);
        String actualResponseString = employeePayrollController.addEmployee(employeeDto);
        assertEquals(successString, actualResponseString);
    }

    @Test
    void givenAEmployeeDetails_whenUpdateEmployeeDetailsCalled_shouldUpdateTheEmployee() {
        String successString = "Employee Details updated successfully";
        int employeeId = 1;
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmployeeName("Alisha");
        employeeDto.setEmployeeSalary(50000);
        employeeDto.setDepartments(List.of("It"));
        employeeDto.setGender("female");
        when(employeePayrollService.updateEmployee(employeeId, employeeDto)).thenReturn(successString);
        String actualResponseString = employeePayrollController.updateEmployee(employeeId,employeeDto);
        assertEquals(successString, actualResponseString);
    }

    @Test
    void givenAEmployeeId_whenDeleteEmployeeDetailsCalled_shouldDeleteTheEmployee() {
        String successString = "Employee details deleted successfully";
        int employeeId = 1;
        when(employeePayrollService.deleteEmployee(employeeId)).thenReturn(successString);
        String actualResponseString = employeePayrollController.deleteEmployee(employeeId);
        assertEquals(successString, actualResponseString);
    }
}
