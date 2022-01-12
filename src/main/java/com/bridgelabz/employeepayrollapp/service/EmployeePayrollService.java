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

/**
 * Purpose: To demonstrate business logic which provides implementation of all methods
 *
 * @author: ALISHA BALAMWAR
 * @since: 2021-12-13
 */
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

    /**
     * Purpose: This method is created to get list of all employee from the repository
     *
     * @return: The list of employee from the repository
     */
    public List<EmployeePayroll> getListOfAllEmployee() {
        return employeeRepo
                .findAll()
                .stream()
                .map(employeeDto -> modelMapper.map(employeeDto, EmployeePayroll.class))
                .collect(Collectors.toList());
    }

    /**
     * Purpose: This method is created add employees to the repository
     *
     * @param employeeDto: This is reference of employee dto class
     * @return: Status of employee details added to the repository
     */
    public String addEmployee(EmployeeDto employeeDto) {
        EmployeePayroll employeePayroll = modelMapper.map(employeeDto, EmployeePayroll.class);
        employeeRepo.save(employeePayroll);
        return EMPLOYEE_ADDED_SUCCESSFULLY;
    }

    /**
     * Purpose: This method is created to find employee details by id
     *
     * @param id: It is reference which help to find employee entity in repository
     * @return: Employee entity of that id
     */
    public EmployeePayroll findEmployeeEntityById(int id) {
        return employeeRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException(INVALID_ID));
    }

    /**
     * Purpose: This method is created to delete employee from the repository
     *
     * @param id: This is reference which help to find entity and delete the employee details
     * @throws ResourceNotFoundException: This exception is thrown if the desired given id is not found
     *                                    and cannot return the entity
     * @return: status of employee details deleted or not
     */
    public String deleteEmployee(int id) throws ResourceNotFoundException {
        EmployeePayroll employeePayroll = findEmployeeEntityById(id);
        employeeRepo.delete(employeePayroll);
        return EMPLOYEE_DELETED_SUCCESSFULLY;
    }

    /**
     * Purpose: This method is created update employee details in the repository
     *
     * @param id:          This sis reference at which the entity needs to be updated
     * @param employeeDto: This is reference for employee dto and holds the details that need to be updated
     * @throws ResourceNotFoundException: This exception is thrown if the desired given id is not found
     *                                    and cannot return the entity
     * @return: Status of employee details updated in the repository.
     */
    public String updateEmployee(int id, EmployeeDto employeeDto) throws ResourceNotFoundException {
        EmployeePayroll employeePayroll = findEmployeeEntityById(id);
        employeePayroll = employeeBuilder.buildEmployeeEntity(employeeDto, employeePayroll);
        employeeRepo.save(employeePayroll);
        return EMPLOYEE_UPDATED_SUCCESSFULLY;
    }

    /**
     * Purpose: To find entry by id if it presents in database
     *
     * @param id: Database id.
     * @return address: Data which has address details
     */
    public EmployeeDto getEmployeeById(int id){
        EmployeePayroll employeePayroll = findEmployeeEntityById(id);
        return modelMapper.map(employeePayroll, EmployeeDto.class);
    }
}
