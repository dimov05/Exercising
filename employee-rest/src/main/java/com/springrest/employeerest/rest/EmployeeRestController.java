package com.springrest.employeerest.rest;

import com.springrest.employeerest.entity.Employee;
import com.springrest.employeerest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeService employeeService;


    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    @GetMapping("/employees/{employeeId}")
    public Optional<Employee> getEmployeeById(@PathVariable int employeeId) {
        Optional<Employee> employee = employeeService.getEmployeeById(employeeId);
        if (employee.isEmpty()) {
            throw new RuntimeException("Employee with id not found - " + employeeId);
        }
        return employeeService.getEmployeeById(employeeId);
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        employee.setId(0);
        return employeeService.save(employee);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployeeById(@PathVariable int employeeId) {
        if (employeeService.getEmployeeById(employeeId).isEmpty()) {
            return "This employee doesn't exist";
        }
        employeeService.deleteById(employeeId);
        return "Employee with ID: " + employeeId + " is deleted";
    }
}
