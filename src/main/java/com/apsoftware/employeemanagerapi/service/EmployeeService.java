package com.apsoftware.employeemanagerapi.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.apsoftware.employeemanagerapi.DTO.EmployeeResponse;
import com.apsoftware.employeemanagerapi.entity.Employee;
import com.apsoftware.employeemanagerapi.entity.Salary;
import com.apsoftware.employeemanagerapi.entity.Title;
import com.apsoftware.employeemanagerapi.repository.DeptEmpRepository;
import com.apsoftware.employeemanagerapi.repository.EmployeeRepository;
import com.apsoftware.employeemanagerapi.repository.SalaryRepository;
import com.apsoftware.employeemanagerapi.repository.TitleRepository;

@Service
public class EmployeeService {
        private static final LocalDate MAX_DATE = LocalDate.of(9999, 1, 1);

        private final EmployeeRepository employeeRepository;

        private final SalaryRepository salaryRepository;
        private final DeptEmpRepository deptEmpRepository;
        private final TitleRepository titleRepository;

        // ✅ constructor injection (good)
        public EmployeeService(EmployeeRepository employeeRepository,
                        SalaryRepository salaryRepository,
                        DeptEmpRepository deptEmpRepository,
                        TitleRepository titleRepository) {

                this.employeeRepository = employeeRepository;
                this.salaryRepository = salaryRepository;
                this.deptEmpRepository = deptEmpRepository;
                this.titleRepository = titleRepository;
        }

        public EmployeeResponse getEmployee(Integer id) {
                Employee e = employeeRepository.findById(id)
                                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));

                return mapToResponse(e);
        }

        public List<EmployeeResponse> getAllEmployees() {
                return employeeRepository.findAll()
                                .stream()
                                .map(this::mapToResponse)
                                .toList();
        }

        private EmployeeResponse mapToResponse(Employee e) {

                String department = deptEmpRepository
                                .findCurrentDepartment(e.getEmpNo(), MAX_DATE)
                                .map(d -> d.getDepartment().getDeptName())
                                .orElse(null);

                String title = titleRepository
                                .findCurrentTitle(e.getEmpNo())
                                .map(Title::getTitle)
                                .orElse(null);

                Integer salary = salaryRepository
                                .findCurrentSalary(e.getEmpNo(), MAX_DATE)
                                .map(Salary::getSalary)
                                .orElse(null);

                return new EmployeeResponse(
                                e.getEmpNo(),
                                e.getFirstName() + " " + e.getLastName(),
                                department,
                                title,
                                salary);
        }
}
