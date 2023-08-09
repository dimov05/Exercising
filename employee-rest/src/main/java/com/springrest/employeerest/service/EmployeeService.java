package com.springrest.employeerest.service;

import com.springrest.employeerest.entity.Employee;
import com.springrest.employeerest.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(int employeeId) {
        return employeeRepository.findById(employeeId);
    }

    @Transactional
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Transactional
    public void deleteById(int employeeId) {
        employeeRepository.deleteById(employeeId);
    }

}
