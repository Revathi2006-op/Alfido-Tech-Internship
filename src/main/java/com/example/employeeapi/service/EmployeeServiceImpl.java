package com.example.employeeapi.service;

import com.example.employeeapi.entity.Employee;
import com.example.employeeapi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    //  GET ALL
    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    //  CREATE
    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    //  UPDATE
    @Override
    public Employee updateEmployee(int id, Employee employee) {
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        existingEmployee.setName(employee.getName());
        existingEmployee.setRole(employee.getRole());

        return employeeRepository.save(existingEmployee);
    }

    //  DELETE
    @Override
    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }
}