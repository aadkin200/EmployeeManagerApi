package com.apsoftware.employeemanagerapi.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "salaries")
@IdClass(SalaryId.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Salary {
	@Id
	@Column(name = "from_date")
	private LocalDate fromDate;
	@Id
	@Column(name = "emp_no")
	private Long empNo;
	private Integer salary;
	@Column(name = "to_date")
	private LocalDate toDate;
	@ManyToOne
    @JoinColumn(name = "emp_no", insertable = false, updatable = false)
    private Employee employee;
}
