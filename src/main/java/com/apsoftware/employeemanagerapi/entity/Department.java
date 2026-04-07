package com.apsoftware.employeemanagerapi.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "departments")
public class Department {

    @Id
    @Column(name = "dept_no")
    private String deptNo;

    @Column(name = "dept_name", nullable = false, unique = true)
    private String deptName;

    @OneToMany(mappedBy = "department")
    private List<DeptEmp> employees = new ArrayList<>();

    @OneToMany(mappedBy = "department")
    private List<DeptManager> managers = new ArrayList<>();

    public String getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(String deptNo) {
        this.deptNo = deptNo;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public List<DeptEmp> getEmployees() {
        return employees;
    }

    public void setEmployees(List<DeptEmp> employees) {
        this.employees = employees;
    }

    public List<DeptManager> getManagers() {
        return managers;
    }

    public void setManagers(List<DeptManager> managers) {
        this.managers = managers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Department))
            return false;
        Department that = (Department) o;
        return Objects.equals(deptNo, that.deptNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deptNo);
    }
}