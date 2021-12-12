package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.builder.EmployeeBuilder;
import com.bridgelabz.employeepayrollapp.dto.EmployeeDto;
import com.bridgelabz.employeepayrollapp.entity.EmployeePayroll;
import com.bridgelabz.employeepayrollapp.repository.EmployeeRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EmployeePayrollServiceTest {

    @InjectMocks
    private EmployeePayrollService employeePayrollService;
    @Mock
    private EmployeeRepo employeeRepo;
    @Mock
    private ModelMapper modelMapper;
    @Mock
    private EmployeeBuilder employeeBuilder;

    @Test
    void givenAListOfEmployeeDetails_whenGetAListOfEmployeeCalled_shouldReturnAListOfEmployeeDTo() {
        List<EmployeePayroll> employeePayrollList = new ArrayList<>();
        EmployeePayroll employeePayroll1 = new EmployeePayroll();
        employeePayroll1.setEmployeeId(1);
        employeePayroll1.setEmployeeName("Alisha");
        employeePayroll1.setEmployeeSalary(50000);
        employeePayroll1.setStart(LocalDateTime.now());
        employeePayrollList.add(employeePayroll1);
        EmployeePayroll employeePayroll2 = new EmployeePayroll();
        employeePayroll2.setEmployeeId(2);
        employeePayroll2.setEmployeeName("Harry");
        employeePayroll2.setEmployeeSalary(80000);
        employeePayroll2.setStart(LocalDateTime.now());
        employeePayrollList.add(employeePayroll2);

        List<EmployeeDto> employeeDtoList = new ArrayList<>();
        EmployeeDto employeeDto1 = new EmployeeDto();
        employeeDto1.setEmployeeName("Alisha");
        employeeDto1.setEmployeeSalary(50000);
        employeeDtoList.add(employeeDto1);
        EmployeeDto employeeDto2 = new EmployeeDto();
        employeeDto2.setEmployeeName("Harry");
        employeeDto2.setEmployeeSalary(80000);
        employeeDtoList.add(employeeDto2);

        when(employeeRepo.findAll()).thenReturn(employeePayrollList);
        when(modelMapper.map(employeePayrollList.get(0), EmployeeDto.class)).thenReturn(employeeDto1);
        when(modelMapper.map(employeePayrollList.get(1), EmployeeDto.class)).thenReturn(employeeDto2);
        List<EmployeeDto> actualListOfEmployee = employeePayrollService.getListOfAllEmployee();
        assertEquals(2, actualListOfEmployee.size());
        assertEquals(employeeDtoList, actualListOfEmployee);

    }
}
