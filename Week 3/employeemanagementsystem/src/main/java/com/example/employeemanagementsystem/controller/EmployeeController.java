package com.example.employeemanagementsystem.controller;

import com.example.employeemanagementsystem.EmployeeService;
import com.example.employeemanagementsystem.model.Employee;
import com.example.employeemanagementsystem.repository.EmployeeRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;
    private EmployeeService employeeService;

    // Create a new employee
    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }
    // Endpoint to get all employees with pagination and sorting
    @GetMapping
    public Page<Employee> getEmployees(Pageable pageable) {
        return employeeService.getEmployees(pageable);
    }

    // Get all employees
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Get an employee by ID
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        return employee.map(ResponseEntity::ok)
                       .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update an employee
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails) {
        return employeeRepository.findById(id)
                .map(employee -> {
                    employee.setName(employeeDetails.getName());
                    employee.setEmail(employeeDetails.getEmail());
                    employee.setDepartment(employeeDetails.getDepartment());
                    Employee updatedEmployee = employeeRepository.save(employee);
                    return ResponseEntity.ok(updatedEmployee);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete an employee
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteEmployee(@PathVariable Long id) {
        return employeeRepository.findById(id)
                .map(employee -> {
                    employeeRepository.delete(employee);
                    return ResponseEntity.noContent().build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    
}
