package com.bridgelabz.employeepayrollapp.integration;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDto;
import com.bridgelabz.employeepayrollapp.entity.EmployeePayroll;
import com.bridgelabz.employeepayrollapp.service.EmployeePayrollService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest
@ActiveProfiles("test")
public class EmployeePayrollControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeePayrollService employeePayrollService;

    @Test
    void givenAEmployeeDto_shouldAddEmployeeTest_returnSuccessMessage() throws Exception {
        when(employeePayrollService.addEmployee(any())).thenReturn("Success");
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/employee")
                        .content("{\n\"employeeName\": \"Alisha\",\n\"gender\":\"female\"," +
                                "\n\"departments\":[\"It\"],\n\"employeeSalary\":\"800000\"\n}")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }

    @Test
    void getListOfAllEmployeeDetailsTest_whenCalleForGetEmployees_shouldReturnList() throws Exception {
        when(employeePayrollService.getListOfAllEmployee()).thenReturn(new ArrayList<>());
        mockMvc.perform(MockMvcRequestBuilders.get("/employee"))
                .andExpect(status().isOk());
    }

    @Test
    void givenEmployeeDto_shouldUpdateEmployeeTest_shouldReturnSuccessMessage() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmployeeName("Alisha");
        employeeDto.setEmployeeSalary(800000);
        employeeDto.setDepartments(List.of("It"));
        employeeDto.setGender("female");
        int id = 1;
        when(employeePayrollService.updateEmployee(id, employeeDto)).thenReturn("success");
        mockMvc.perform(MockMvcRequestBuilders
                        .put("/employee/1")
                        .content("{\n\"employeeName\": \"Alisha\",\n\"gender\":\"female\"," +
                                "\n\"departments\":[\"It\"],\n\"employeeSalary\":\"800000\"\n}")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }

    @Test
    void givenEmployeeId_whenCalledForDeleteAddressBookTest_shouldReturnSuccessMessage() throws Exception {
        when(employeePayrollService.deleteEmployee(1)).thenReturn("success");
        mockMvc.perform(MockMvcRequestBuilders
                        .delete("/employee/1")
                        .content("{\n\"employeeName\": \"Alisha\",\n\"gender\":\"female\"," +
                                "\n\"departments\":[\"It\"],\n\"employeeSalary\":\"800000\"\n}")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }
}
