package com.apsoftware.employeemanagerapi.entity;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SalaryId implements Serializable {
	private Long empNo;
	private LocalDate fromDate;
}
