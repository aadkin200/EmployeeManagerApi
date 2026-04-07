package com.apsoftware.employeemanagerapi.DTO;

public class EmployeeResponse {

    private Integer empNo;
    private String fullName;
    private String department;
    private String title;
    private Integer salary;

    public EmployeeResponse(Integer empNo, String fullName, String department, String title, Integer salary) {
        this.empNo = empNo;
        this.fullName = fullName;
        this.department = department;
        this.title = title;
        this.salary = salary;
    }

    public Integer getEmpNo() {
        return empNo;
    }

    public String getFullName() {
        return fullName;
    }

    public String getDepartment() {
        return department;
    }

    public String getTitle() {
        return title;
    }

    public Integer getSalary() {
        return salary;
    }
}
