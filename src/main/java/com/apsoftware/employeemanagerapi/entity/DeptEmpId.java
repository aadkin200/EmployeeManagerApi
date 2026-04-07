package com.apsoftware.employeemanagerapi.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class DeptEmpId implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "emp_no")
    private Integer empNo;
	
	@Column(name = "dept_no")
    private String deptNo;

    // getters/setters

    public Integer getEmpNo() { return empNo; }
    public void setEmpNo(Integer empNo) { this.empNo = empNo; }

    public String getDeptNo() { return deptNo; }
    public void setDeptNo(String deptNo) { this.deptNo = deptNo; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DeptEmpId)) return false;
        DeptEmpId that = (DeptEmpId) o;
        return Objects.equals(empNo, that.empNo) &&
               Objects.equals(deptNo, that.deptNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empNo, deptNo);
    }
}
