package com.apsoftware.employeemanagerapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apsoftware.employeemanagerapi.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, String> {
	Optional<Department> findByDeptName(String deptName);
}
