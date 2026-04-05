package service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.apsoftware.employeemanagerapi.entity.Employee;

import DTO.EmployeeResponse;
import repository.EmployeeRepository;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public EmployeeResponse getEmployee(Integer id) {
        Employee e = employeeRepository.findById(id).orElseThrow();

        return mapToResponse(e);
    }

    public List<EmployeeResponse> getAllEmployees() {
        return employeeRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    private EmployeeResponse mapToResponse(Employee e) {
        return new EmployeeResponse(
            e.getEmpNo(),
            e.getFirstName() + " " + e.getLastName(),
            null,   // fill later
            null,   // fill later
            null    // fill later
        );
    }
}
