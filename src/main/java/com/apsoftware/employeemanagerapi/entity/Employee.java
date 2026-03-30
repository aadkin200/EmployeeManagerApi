package com.apsoftware.employeemanagerapi.entity;

import java.time.LocalDate;
import java.util.List;

import com.apsoftware.employeemanagerapi.enums.Gender;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employees")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {
	@Id
	@Column(name = "emp_no")
	private Long empNo;
	
	@Column(name = "birth_date", nullable = false)
	private LocalDate birthDate;
	
	@Column(name = "first_name", nullable = false, length = 14)
	private String firstName;
	
	@Column(name = "last_name", nullable = false, length = 16)
	private String lastName;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "gender", nullable = false)
	private Gender gender;
	
	@Column(name = "hire_date", nullable = false)
	private LocalDate hireDate;
	
	@JsonIgnore
	@OneToMany(mappedBy = "employee")
    private List<Salary> salaries;
	
	@JsonIgnore
    @OneToMany(mappedBy = "employee")
    private List<Title> titles;
    
	@JsonIgnore
    @OneToMany(mappedBy = "employee")
    private List<DeptEmp> departments;
    
	@JsonIgnore
    @OneToMany(mappedBy = "employee")
    private List<DeptManager> managedDepartments;
}
