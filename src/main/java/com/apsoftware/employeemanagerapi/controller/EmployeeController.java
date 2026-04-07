package com.apsoftware.employeemanagerapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apsoftware.employeemanagerapi.DTO.EmployeeResponse;
import com.apsoftware.employeemanagerapi.entity.Employee;
import com.apsoftware.employeemanagerapi.repository.EmployeeRepository;
import com.apsoftware.employeemanagerapi.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/{id}")
    public EmployeeResponse getEmployee(@PathVariable Integer id) {
        return employeeService.getEmployee(id);
    }

    @GetMapping
    public List<EmployeeResponse> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
}
