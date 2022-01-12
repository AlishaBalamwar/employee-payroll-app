//package com.bridgelabz.employeepayrollapp.service;
//
//import com.bridgelabz.employeepayrollapp.builder.EmployeeBuilder;
//import com.bridgelabz.employeepayrollapp.dto.EmployeeDto;
//import com.bridgelabz.employeepayrollapp.entity.EmployeePayroll;
//import com.bridgelabz.employeepayrollapp.exception.ResourceNotFoundException;
//import com.bridgelabz.employeepayrollapp.repository.EmployeeRepo;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.ArgumentCaptor;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.modelmapper.ModelMapper;
//
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//public class EmployeePayrollServiceTest {
//
//    @InjectMocks
//    private EmployeePayrollService employeePayrollService;
//    @Mock
//    private EmployeeRepo employeeRepo;
//    @Mock
//    private ModelMapper modelMapper;
//    @Mock
//    private EmployeeBuilder employeeBuilder;
//
//    @Test
//    void givenAListOfEmployeeDetails_whenGetAListOfEmployeeCalled_shouldReturnAListOfEmployeeDTo() {
//        List<EmployeePayroll> employeePayrollList = new ArrayList<>();
//        EmployeePayroll employeePayroll1 = new EmployeePayroll();
//        employeePayroll1.setEmployeeId(1);
//        employeePayroll1.setName("Alisha");
//        employeePayroll1.setSalary(50000);
//        employeePayroll1.setDepartments(List.of("It"));
//        employeePayroll1.setGender("female");
//        employeePayroll1.setStart(LocalDateTime.now());
//        employeePayrollList.add(employeePayroll1);
//        EmployeePayroll employeePayroll2 = new EmployeePayroll();
//        employeePayroll2.setEmployeeId(2);
//        employeePayroll2.setName("Harry");
//        employeePayroll2.setSalary(80000);
//        employeePayroll2.setDepartments(List.of("Electrical"));
//        employeePayroll2.setGender("male");
//        employeePayroll2.setStart(LocalDateTime.now());
//        employeePayrollList.add(employeePayroll2);
//
//        List<EmployeeDto> employeeDtoList = new ArrayList<>();
//        EmployeeDto employeeDto1 = new EmployeeDto();
//        employeeDto1.setEmployeeName("Alisha");
//        employeeDto1.setEmployeeSalary(50000);
//        employeeDto1.setDepartments(List.of("It"));
//        employeeDto1.setGender("female");
//        employeeDtoList.add(employeeDto1);
//        EmployeeDto employeeDto2 = new EmployeeDto();
//        employeeDto2.setEmployeeName("Harry");
//        employeeDto2.setEmployeeSalary(80000);
//        employeeDto2.setDepartments(List.of("It"));
//        employeeDto2.setGender("male");
//        employeeDtoList.add(employeeDto2);
//
//        when(employeeRepo.findAll()).thenReturn(employeePayrollList);
//        when(modelMapper.map(employeePayrollList.get(0), EmployeeDto.class)).thenReturn(employeeDto1);
//        when(modelMapper.map(employeePayrollList.get(1), EmployeeDto.class)).thenReturn(employeeDto2);
//        List<EmployeeDto> actualListOfEmployee = employeePayrollService.getListOfAllEmployee();
//        assertEquals(2, actualListOfEmployee.size());
//        assertEquals(employeeDtoList, actualListOfEmployee);
//    }
//
//    @Test
//    void givenEmployeePayrollDto_whenCalledAddEmployee_shouldReturnSuccessMessage() {
//        String successMessage = "Employee added successfully";
//        EmployeeDto employeeDto = new EmployeeDto();
//        employeeDto.setEmployeeName("Alisha");
//        employeeDto.setEmployeeSalary(80000);
//        employeeDto.setDepartments(List.of("It"));
//        employeeDto.setGender("female");
//
//        EmployeePayroll employeePayroll = new EmployeePayroll();
//        employeePayroll.setEmployeeId(1);
//        employeePayroll.setName("Alisha");
//        employeePayroll.setSalary(80000);
//        employeePayroll.setDepartments(List.of("It"));
//        employeePayroll.setGender("female");
//        employeePayroll.setStart(LocalDateTime.now());
//
//        when(modelMapper.map(employeeDto, EmployeePayroll.class)).thenReturn(employeePayroll);
//        String actualMessage = employeePayrollService.addEmployee(employeeDto);
//        assertEquals(successMessage, actualMessage);
//        verify(employeeRepo, times(1)).save(employeePayroll);
//    }
//
//    @Test
//    void givenEmployeeIdPayrollDto_whenCalledDeleteEmployee_shouldReturnSuccessMessage() {
//        String successMessage = "Employee details deleted successfully";
//        int employeeId = 1;
//        EmployeeDto employeeDto = new EmployeeDto();
//        employeeDto.setEmployeeName("Alisha");
//        employeeDto.setEmployeeSalary(80000);
//        employeeDto.setDepartments(List.of("It"));
//        employeeDto.setGender("female");
//
//        EmployeePayroll employeePayroll = new EmployeePayroll();
//        employeePayroll.setEmployeeId(1);
//        employeePayroll.setName("Alisha");
//        employeePayroll.setSalary(80000);
//        employeePayroll.setDepartments(List.of("It"));
//        employeePayroll.setGender("female");
//        employeePayroll.setStart(LocalDateTime.now());
//
//        when(employeeRepo.findById(employeeId)).thenReturn(Optional.of(employeePayroll));
//        String actualMessage = employeePayrollService.deleteEmployee(employeeId);
//        assertEquals(successMessage, actualMessage);
//        verify(employeeRepo, times(1)).delete(employeePayroll);
//    }
//
//    @Test
//    void givenEmployeeIdPayrollDto_whenCalledUpdateEmployee_shouldReturnSuccessMessage() {
//        int employeeId = 1;
//        ArgumentCaptor<EmployeePayroll> employeePayrollArgumentCaptor = ArgumentCaptor.forClass(EmployeePayroll.class);
//        String successMessage = "Employee Details updated successfully";
//        EmployeeDto employeeDto = new EmployeeDto();
//        employeeDto.setEmployeeName("Alisha");
//        employeeDto.setEmployeeSalary(80000);
//        employeeDto.setDepartments(List.of("It"));
//        employeeDto.setGender("female");
//
//        EmployeePayroll employeePayroll = new EmployeePayroll();
//        employeePayroll.setEmployeeId(1);
//        employeePayroll.setName("Alisha");
//        employeePayroll.setSalary(80000);
//        employeePayroll.setDepartments(List.of("It"));
//        employeePayroll.setGender("female");
//        employeePayroll.setStart(LocalDateTime.now());
//
//        when(employeeRepo.findById(employeeId)).thenReturn(Optional.of(employeePayroll));
//        when(employeeBuilder.buildEmployeeEntity(employeeDto, employeePayroll)).thenReturn(employeePayroll);
//        String actualMessage = employeePayrollService.updateEmployee(employeeId, employeeDto);
//        assertEquals(successMessage, actualMessage);
//        verify(employeeRepo, times(1)).save(employeePayrollArgumentCaptor.capture());
//        assertEquals(employeePayroll.getName(), employeePayrollArgumentCaptor.getValue().getName());
//        assertEquals(employeePayroll.getSalary(), employeePayrollArgumentCaptor.getValue().getSalary());
//    }
//
//
//    @Test
//    void givenAEmployeeDetails_whenUpdateEmployeeIsCalled_shouldThrowExceptionMessage() {
//        int employeeId = 1;
//        EmployeeDto employeeDto = new EmployeeDto();
//        employeeDto.setEmployeeName("Alisha");
//        employeeDto.setEmployeeSalary(80000);
//        employeeDto.setDepartments(List.of("It"));
//        employeeDto.setGender("female");
//        when(employeeRepo.findById(employeeId)).thenReturn(Optional.empty());
//        assertThrows(ResourceNotFoundException.class, () -> employeePayrollService.updateEmployee(employeeId, employeeDto));
//    }
//}
