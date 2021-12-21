package com.bridgelabz.employeepayrollapp.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Purpose: To contain entites in database
 *
 * @author: ALISHA BALAMWAR
 * @since: 2021-12-13
 */
@Entity
@Getter
@Setter
@Table(name = "employeePayroll")
public class EmployeePayroll {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "EMPLOYEE_ID")
    private int employeeId;
    @Column(name = "EMPLOYEE_NAME")
    private String employeeName;
    @Column(name = "GENDER")
    private String gender;
    @ElementCollection
    @CollectionTable(name = "employee_department", joinColumns = @JoinColumn(name = "D_id"))
    @Column(name = "DEPARTMENT")
    private List<String> departments;
    @Column(name = "EMPLOYEE_SALARY")
    private long employeeSalary;
    @Column(name = "START_DATE")
    @CreationTimestamp
    private LocalDateTime Start;
}
