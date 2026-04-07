package com.apsoftware.employeemanagerapi.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.apsoftware.employeemanagerapi.enums.Gender;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @Column(name = "emp_no")
    private Integer empNo;

    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "hire_date", nullable = false)
    private LocalDate hireDate;

    @OneToMany(mappedBy = "employee")
    private List<Salary> salaries = new ArrayList<>();

    @OneToMany(mappedBy = "employee")
    private List<Title> titles = new ArrayList<>();

    @OneToMany(mappedBy = "employee")
    private List<DeptEmp> departments = new ArrayList<>();

    @OneToMany(mappedBy = "employee")
    private List<DeptManager> managedDepartments = new ArrayList<>();

    // getters/setters

    public Integer getEmpNo() { return empNo; }
    public void setEmpNo(Integer empNo) { this.empNo = empNo; }

    public LocalDate getBirthDate() { return birthDate; }
    public void setBirthDate(LocalDate birthDate) { this.birthDate = birthDate; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public Gender getGender() { return gender; }
    public void setGender(Gender gender) { this.gender = gender; }

    public LocalDate getHireDate() { return hireDate; }
    public void setHireDate(LocalDate hireDate) { this.hireDate = hireDate; }

    public List<Salary> getSalaries() { return salaries; }
    public void setSalaries(List<Salary> salaries) { this.salaries = salaries; }

    public List<Title> getTitles() { return titles; }
    public void setTitles(List<Title> titles) { this.titles = titles; }

    public List<DeptEmp> getDepartments() { return departments; }
    public void setDepartments(List<DeptEmp> departments) { this.departments = departments; }

    public List<DeptManager> getManagedDepartments() { return managedDepartments; }
    public void setManagedDepartments(List<DeptManager> managedDepartments) { this.managedDepartments = managedDepartments; }

    // equals/hashCode (ONLY ID)

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee that = (Employee) o;
        return Objects.equals(empNo, that.empNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empNo);
    }
}
