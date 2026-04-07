package com.apsoftware.employeemanagerapi.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.apsoftware.employeemanagerapi.entity.Salary;
import com.apsoftware.employeemanagerapi.entity.SalaryId;

public interface SalaryRepository extends JpaRepository<Salary, SalaryId> {

    @Query("SELECT s FROM Salary s WHERE s.employee.empNo = :empNo AND :maxDate BETWEEN s.id.fromDate AND s.toDate")
    Optional<Salary> findCurrentSalary(@Param("empNo") Integer empNo,
                                       @Param("maxDate") LocalDate maxDate);
}