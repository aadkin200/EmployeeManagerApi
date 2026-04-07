package com.apsoftware.employeemanagerapi.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apsoftware.employeemanagerapi.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	List<Employee> findByLastName(String lastName);

    List<Employee> findByFirstNameAndLastName(String firstName, String lastName);

    List<Employee> findByHireDateAfter(LocalDate date);
}
