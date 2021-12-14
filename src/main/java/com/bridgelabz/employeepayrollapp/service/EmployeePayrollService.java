package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.builder.EmployeeBuilder;
import com.bridgelabz.employeepayrollapp.dto.EmployeeDto;
import com.bridgelabz.employeepayrollapp.entity.EmployeePayroll;
import com.bridgelabz.employeepayrollapp.exception.ResourceNotFoundException;
import com.bridgelabz.employeepayrollapp.repository.EmployeeRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeePayrollService {
    private static final String EMPLOYEE_ADDED_SUCCESSFULLY = "Employee added successfully";
    private static final String INVALID_ID = "Invalid Id";
    private static final String EMPLOYEE_DELETED_SUCCESSFULLY = "Employee details deleted successfully";
    private static final String EMPLOYEE_UPDATED_SUCCESSFULLY = "Employee Details updated successfully";
    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private EmployeeBuilder employeeBuilder;

    public List<EmployeeDto> getListOfAllEmployee() {
        return employeeRepo
                .findAll()
                .stream()
                .map(employeePayroll -> modelMapper.map(employeePayroll, EmployeeDto.class))
                .collect(Collectors.toList());
    }

    public String addEmployee(EmployeeDto employeeDto) {
        EmployeePayroll employeePayroll = modelMapper.map(employeeDto, EmployeePayroll.class);
        employeeRepo.save(employeePayroll);
        return EMPLOYEE_ADDED_SUCCESSFULLY;
    }

    private EmployeePayroll findAtmEntityById(int id) {
        return employeeRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException(INVALID_ID));
    }

    public String deleteEmployee(int id) throws ResourceNotFoundException {
        EmployeePayroll employeePayroll = findAtmEntityById(id);
        employeeRepo.delete(employeePayroll);
        return EMPLOYEE_DELETED_SUCCESSFULLY;
    }

    public String updateEmployee(int id, EmployeeDto employeeDto) throws ResourceNotFoundException {
        EmployeePayroll employeePayroll = findAtmEntityById(id);
        employeePayroll = employeeBuilder.buildEmployeeEntity(employeeDto, employeePayroll);
        employeeRepo.save(employeePayroll);
        return EMPLOYEE_UPDATED_SUCCESSFULLY;
    }
}
