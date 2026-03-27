package com.apsoftware.employeemanagerapi.entity;

import java.time.LocalDate;

import com.apsoftware.employeemanagerapi.enums.Gender;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
public class Employee {
	@Id
	@Column(name = "emp_no")
	private int id;
	@Column(name = "birth_date")
	private LocalDate birthDate;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	private Gender gender;
	@Column(name = "hire_date")
	private LocalDate hireDate;
}
