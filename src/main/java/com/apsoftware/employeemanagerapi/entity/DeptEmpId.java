package com.apsoftware.employeemanagerapi.entity;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class DeptEmpId implements Serializable {
	
    private Integer empNo;
    
    private String deptNo;
    
}
