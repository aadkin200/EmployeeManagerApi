package com.apsoftware.employeemanagerapi.entity;

import java.util.List;

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
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {
	@Id
    @Column(name = "dept_no", length = 4)
    private String deptNo;
	
    @Column(name = "dept_name", nullable = false, unique = true)
    private String deptName;
    
    @OneToMany(mappedBy = "department")
    private List<DeptEmp> employees;
    
    @OneToMany(mappedBy = "department")
    private List<DeptManager> managers;
}
