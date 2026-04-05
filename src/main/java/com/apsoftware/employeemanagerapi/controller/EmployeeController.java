package controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apsoftware.employeemanagerapi.entity.Employee;

import repository.EmployeeRepository;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable Integer id) {
        return employeeRepository.findById(id).orElseThrow();
    }

    @GetMapping
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }
}
