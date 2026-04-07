package com.apsoftware.employeemanagerapi.entity;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.*;

@Entity
@Table(name = "salaries")
public class Salary {

    @EmbeddedId
    private SalaryId id;

    @ManyToOne
    @MapsId("empNo")
    @JoinColumn(name = "emp_no", insertable = false, updatable = false)
    private Employee employee;

    @Column(name = "salary", nullable = false)
    private Integer salary;

    @Column(name = "to_date", nullable = false)
    private LocalDate toDate;

    // getters/setters

    public SalaryId getId() { return id; }
    public void setId(SalaryId id) { this.id = id; }

    public Employee getEmployee() { return employee; }
    public void setEmployee(Employee employee) { this.employee = employee; }

    public Integer getSalary() { return salary; }
    public void setSalary(Integer salary) { this.salary = salary; }

    public LocalDate getToDate() { return toDate; }
    public void setToDate(LocalDate toDate) { this.toDate = toDate; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Salary)) return false;
        Salary that = (Salary) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}