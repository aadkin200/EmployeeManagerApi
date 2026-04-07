package com.apsoftware.employeemanagerapi.entity;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.*;

@Entity
@Table(name = "titles")
public class Title {

    @EmbeddedId
    private TitleId id;

    @ManyToOne
    @MapsId("empNo")
    @JoinColumn(name = "emp_no", insertable = false, updatable = false)
    private Employee employee;

    @Column(name = "to_date")
    private LocalDate toDate;

    // getters/setters

    public TitleId getId() {
        return id;
    }

    public void setId(TitleId id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    // convenience methods (these are GOOD, keep them)

    public String getTitle() {
        return id != null ? id.getTitle() : null;
    }

    public LocalDate getFromDate() {
        return id != null ? id.getFromDate() : null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Title))
            return false;
        Title that = (Title) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}