package com.apsoftware.employeemanagerapi.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "dept_emp")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeptEmp {
    @EmbeddedId
    private DeptEmpId id;

    @ManyToOne
    @MapsId("empNo")
    @JoinColumn(name = "emp_no")
    private Employee employee;

    @ManyToOne
    @MapsId("deptNo")
    @JoinColumn(name = "dept_no")
    private Department department;
    
    @Column(name = "from_date")
    private LocalDate fromDate;
    
    @Column(name = "to_date")
    private LocalDate toDate;
}
