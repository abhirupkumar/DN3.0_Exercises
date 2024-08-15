package com.example.employeemanagementsystem.controller;

import com.example.employeemanagementsystem.EmployeeService;
import com.example.employeemanagementsystem.model.Department;
import com.example.employeemanagementsystem.model.Employee;
import com.example.employeemanagementsystem.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    @Autowired
    private DepartmentRepository departmentRepository;
    private EmployeeService employeeService;

    // Create a new department
    @PostMapping
    public Department createDepartment(@RequestBody Department department) {
        return departmentRepository.save(department);
    }

    // Get all departments
    @GetMapping
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    // Get a department by ID
    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable Long id) {
        Optional<Department> department = departmentRepository.findById(id);
        return department.map(ResponseEntity::ok)
                         .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update a department
    @PutMapping("/{id}")
    public ResponseEntity<Department> updateDepartment(@PathVariable Long id, @RequestBody Department departmentDetails) {
        return departmentRepository.findById(id)
                .map(department -> {
                    department.setName(departmentDetails.getName());
                    Department updatedDepartment = departmentRepository.save(department);
                    return ResponseEntity.ok(updatedDepartment);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete a department
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteDepartment(@PathVariable Long id) {
        return departmentRepository.findById(id)
                .map(department -> {
                    departmentRepository.delete(department);
                    return ResponseEntity.noContent().build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());

    }
    // Endpoint to get employees by department with pagination and sorting
    @GetMapping("/department/{department}")
    public Page<Employee> getEmployeesByDepartment(@PathVariable String department, Pageable pageable) {
        return employeeService.getEmployeesByDepartment(department, pageable);
}
}
