package com.apsoftware.employeemanagerapi.entity;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class TitleId implements Serializable {
	
    private Integer empNo;
    
    private String title;
    
    private LocalDate fromDate;
    
}
