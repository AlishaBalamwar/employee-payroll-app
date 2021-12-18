package com.bridgelabz.employeepayrollapp.repository;

import com.bridgelabz.employeepayrollapp.entity.EmployeePayroll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Purpose: This class is created  for repository
 *
 * @author: ALISHA BALAMWAR
 * @since: 2021-12-13
 */
@Repository
public interface EmployeeRepo extends JpaRepository<EmployeePayroll, Integer> {
}
