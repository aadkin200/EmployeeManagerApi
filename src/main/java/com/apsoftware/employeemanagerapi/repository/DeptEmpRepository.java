package com.apsoftware.employeemanagerapi.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.apsoftware.employeemanagerapi.entity.DeptEmp;
import com.apsoftware.employeemanagerapi.entity.DeptEmpId;

public interface DeptEmpRepository extends JpaRepository<DeptEmp, DeptEmpId> {

    @Query("SELECT d FROM DeptEmp d WHERE d.employee.empNo = :empNo AND :maxDate BETWEEN d.fromDate AND d.toDate")
    Optional<DeptEmp> findCurrentDepartment(@Param("empNo") Integer empNo,
            @Param("maxDate") LocalDate maxDate);
}