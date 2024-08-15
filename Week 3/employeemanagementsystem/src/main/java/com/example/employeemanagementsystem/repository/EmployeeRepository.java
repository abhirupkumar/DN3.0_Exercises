package com.example.employeemanagementsystem.repository;

// package com.example.employeemanagementsystem.repository;

// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.repository.query.Param;

// import com.example.employeemanagementsystem.model.Employee;

// import java.util.List;

// public interface EmployeeRepository extends JpaRepository<Employee, Long> {
//     // Custom query using JPQL
//     @Query("SELECT e FROM Employee e WHERE e.salary > :salary")
//     List<Employee> findEmployeesWithSalaryGreaterThan(@Param("salary") Double salary);

//     // Custom query using native SQL
//     @Query(value = "SELECT * FROM employees WHERE department = :department", nativeQuery = true)
//     List<Employee> findEmployeesByDepartmentNative(@Param("department") String department);
// }
import com.example.projection.EmployeeProjection;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.dto.EmployeeDTO;
import com.example.employeemanagementsystem.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // Method to find all employees with pagination and sorting
    Page<Employee> findAll(Pageable pageable);

    // Custom query with pagination and sorting by department
    Page<Employee> findByDepartment(String department, Pageable pageable);

    @Query("SELECT e FROM Employee e")
    List<EmployeeProjection> findAllProjected();
    List<EmployeeDTO> findAllDto();

    void clear();
    void flush();
}

