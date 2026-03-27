package com.apsoftware.employeemanagerapi.entity;

import java.time.LocalDate;

import com.apsoftware.employeemanagerapi.enums.Gender;

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
	private Long id;
	@Column(name = "birth_date")
	private LocalDate birthDate;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Enumerated(EnumType.STRING)
	private Gender gender;
	@Column(name = "hire_date")
	private LocalDate hireDate;
	@OneToMany(mappedBy = "employee")
	private Salary salary;
}
