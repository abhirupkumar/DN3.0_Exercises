package com.example.employeemanagementsystem;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.employeemanagementsystem.model.Employee;
import com.example.employeemanagementsystem.repository.EmployeeRepository;

import jakarta.transaction.Transactional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    // Method to get paginated and sorted employees
    public Page<Employee> getEmployees(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    // Method to get employees by department with pagination and sorting
    public Page<Employee> getEmployeesByDepartment(String department, Pageable pageable) {
        return employeeRepository.findByDepartment(department, pageable);
    }
    @Transactional
    public void saveAllEmployees(List<Employee> employees) {
        int batchSize = 50; // Define your batch size
        for (int i = 0; i < employees.size(); i++) {
            employeeRepository.save(employees.get(i));
            if (i % batchSize == 0 && i > 0) {
                // Flush a batch of inserts and clear the session
                employeeRepository.flush();
                employeeRepository.clear();
            }
        }
    }
}
