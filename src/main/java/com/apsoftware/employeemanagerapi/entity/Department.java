package com.apsoftware.employeemanagerapi.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "departments")
public class Department {
	@Id
    @Column(name = "dept_no", length = 4)
    private String deptNo;
	
    @Column(name = "dept_name", nullable = false, unique = true)
    private String deptName;
    
    @JsonIgnore
    @OneToMany(mappedBy = "department")
    private List<DeptEmp> employees;
    
    @JsonIgnore
    @OneToMany(mappedBy = "department")
    private List<DeptManager> managers;
    
    
}
