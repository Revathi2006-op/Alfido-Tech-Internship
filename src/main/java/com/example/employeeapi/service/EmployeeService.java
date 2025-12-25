package com.example.employeeapi.service;

import com.example.employeeapi.entity.Employee;
import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();

    Employee createEmployee(Employee employee);

    Employee updateEmployee(int id, Employee employee);

    void deleteEmployee(int id);
}