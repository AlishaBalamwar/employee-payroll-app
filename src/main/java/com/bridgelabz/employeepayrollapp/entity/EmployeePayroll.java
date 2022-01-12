package com.bridgelabz.employeepayrollapp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employeePayroll")
public class EmployeePayroll {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "IMAGE")
    private String profileUrl;
    @Column(name = "GENDER")
    private String gender;
    @ElementCollection
    @CollectionTable(name = "employee_department", joinColumns = @JoinColumn(name = "D_id"))
    @Column(name = "DEPARTMENT")
    private List<String> departmentValue;
    @Column(name = "SALARY")
    private long salary;
    @Column(name = "START_DATE")
    @CreationTimestamp
    private LocalDateTime startDate;
    @Column(name = "NOTES")
    private String notes;
}
