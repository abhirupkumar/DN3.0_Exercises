package com.example.dto;

public class EmployeeDTO {
    private String name;
    private Double salary;

    public EmployeeDTO(String name, Double salary) {
        this.name = name;
        this.salary = salary;
    }

    // Getters
    public String getName() {
        return name;
    }

    public Double getSalary() {
        return salary;
    }
}
