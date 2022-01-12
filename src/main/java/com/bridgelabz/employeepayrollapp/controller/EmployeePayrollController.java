package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDto;
import com.bridgelabz.employeepayrollapp.entity.EmployeePayroll;
import com.bridgelabz.employeepayrollapp.entity.ResponseEntity;
import com.bridgelabz.employeepayrollapp.service.EmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Purpose: To demonstrate different HTTP methods
 *
 * @author: ALISHA BALAMWAR
 * @since:2021-12-13
 */
@CrossOrigin("*")
@RestController
public class EmployeePayrollController {

    @Autowired
    private EmployeePayrollService employeePayrollService;

    /**
     * Purpose: This method is created to get all employee details from repository
     *
     * @return: List of all the employees from repository
     */
    @GetMapping(value = "/employee")
    public List<EmployeePayroll> getListOfAllEmployee() {
        return employeePayrollService.getListOfAllEmployee();
    }

    /**
     * Purpose: This method is created to add employee from POJO class to entity in the repository
     *
     * @param employeeDto: It is reference of employee dto class
     * @return: Status of employee added to the repository
     */
    @PostMapping(value = "/employee")
    public ResponseEntity addEmployee(@Valid @RequestBody EmployeeDto employeeDto) {
       String successMessage = employeePayrollService.addEmployee(employeeDto);
       return new ResponseEntity(successMessage, employeeDto, HttpStatus.OK);
    }

    /**
     * Purpose: To get entry from database
     *
     * @param id: Database id which has to be shown
     * @return: ResponseEntity: Having successMessage, data &
     * success status response code indicates that the request has succeeded.
     */
    @GetMapping(value = "/employee/{id}")
    public ResponseEntity getEmployeeById(@PathVariable(name = "id") int id){
        EmployeeDto employeeDto = employeePayrollService.getEmployeeById(id);
        String getAddressMessage = "The address for the given id is here: ";
        return new ResponseEntity(getAddressMessage, employeeDto, HttpStatus.OK);
    }

    /**
     * Purpose: This method is created to delete employee from repository
     *
     * @param id: It is reference to get us know the place from where to delete in the repository
     * @return: Status of employee deleted from repository or not
     */
    @DeleteMapping("/employee/{id}")
    public ResponseEntity deleteEmployee(@PathVariable int id) {
        EmployeeDto employeeDto = employeePayrollService.getEmployeeById(id);
        String deleteMessage = employeePayrollService.deleteEmployee(id);
        return new ResponseEntity(deleteMessage, employeeDto, HttpStatus.OK);
    }

    /**
     * Purpose: This method is created to update employee in the repository
     *
     * @param id: It is reference for updating the given dto which is provided
     * @param employeeDto: It is reference for getting updated employee dto and update in the repository
     * @return: Status of employee details updated in the repository
     */
    @PutMapping("/employee/{id}")
    public ResponseEntity updateEmployee(@PathVariable(value = "id") int id,
                                 @Valid @RequestBody EmployeeDto employeeDto) {
        String updateMessage = employeePayrollService.updateEmployee(id, employeeDto);
        return new ResponseEntity(updateMessage, employeeDto, HttpStatus.OK);
    }
}
