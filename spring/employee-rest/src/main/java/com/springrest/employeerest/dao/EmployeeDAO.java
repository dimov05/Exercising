package com.springrest.employeerest.dao;

import com.springrest.employeerest.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
}
