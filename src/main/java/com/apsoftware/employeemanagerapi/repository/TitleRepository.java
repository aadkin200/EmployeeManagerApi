package com.apsoftware.employeemanagerapi.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.apsoftware.employeemanagerapi.entity.Title;
import com.apsoftware.employeemanagerapi.entity.TitleId;

public interface TitleRepository extends JpaRepository<Title, TitleId> {

    @Query("SELECT t FROM Title t WHERE t.employee.empNo = :empNo AND :today BETWEEN t.id.fromDate AND t.toDate")
    Optional<Title> findCurrentTitle(Integer empNo, LocalDate today);

    // Overload without parameter
    default Optional<Title> findCurrentTitle(Integer empNo) {
        return findCurrentTitle(empNo, LocalDate.now());
    }
}