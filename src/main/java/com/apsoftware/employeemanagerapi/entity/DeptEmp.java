package com.apsoftware.employeemanagerapi.entity;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "dept_emp")
public class DeptEmp {

    @EmbeddedId
    private DeptEmpId id;

    @ManyToOne
    @MapsId("empNo")
    @JoinColumn(name = "emp_no", insertable = false, updatable = false)
    private Employee employee;

    @ManyToOne
    @MapsId("deptNo")
    @JoinColumn(name = "dept_no", insertable = false, updatable = false)
    private Department department;

    @Column(name = "from_date")
    private LocalDate fromDate;

    @Column(name = "to_date")
    private LocalDate toDate;

    // getters/setters

    public DeptEmpId getId() { return id; }
    public void setId(DeptEmpId id) { this.id = id; }

    public Employee getEmployee() { return employee; }
    public void setEmployee(Employee employee) { this.employee = employee; }

    public Department getDepartment() { return department; }
    public void setDepartment(Department department) { this.department = department; }

    public LocalDate getFromDate() { return fromDate; }
    public void setFromDate(LocalDate fromDate) { this.fromDate = fromDate; }

    public LocalDate getToDate() { return toDate; }
    public void setToDate(LocalDate toDate) { this.toDate = toDate; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DeptEmp)) return false;
        DeptEmp that = (DeptEmp) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}