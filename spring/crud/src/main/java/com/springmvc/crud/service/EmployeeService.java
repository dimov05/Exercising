package com.springmvc.crud.service;

import com.springmvc.crud.model.dto.RegisterEmployeeDTO;
import com.springmvc.crud.model.entity.Employee;
import com.springmvc.crud.model.entity.Role;
import com.springmvc.crud.model.enums.UserRolesEnum;
import com.springmvc.crud.repository.EmployeeRepository;
import com.springmvc.crud.repository.RoleRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationNotSupportedException;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final RoleRepository roleRepository;
    private final UserDetailsService userDetailsService;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    public EmployeeService(EmployeeRepository employeeRepository, RoleRepository roleRepository, UserDetailsService userDetailsService, ModelMapper modelMapper, PasswordEncoder passwordEncoder) {
        this.employeeRepository = employeeRepository;
        this.roleRepository = roleRepository;
        this.userDetailsService = userDetailsService;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public void register(RegisterEmployeeDTO registerEmployeeDTO) {
        Employee employee = this.modelMapper.map(registerEmployeeDTO, Employee.class);

        employee.setPassword(this.passwordEncoder.encode(registerEmployeeDTO.getPassword()));

        Role role = this.roleRepository.findByRole(UserRolesEnum.EMPLOYEE);
        employee.setRoles(List.of(role));

        this.employeeRepository.save(employee);
        loginEmployee(employee);
    }

    private void loginEmployee(Employee employee) {
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(employee.getUsername());

        Authentication auth = new UsernamePasswordAuthenticationToken(
                userDetails, userDetails.getPassword(), userDetails.getAuthorities());

        SecurityContextHolder.getContext().setAuthentication(auth);
    }


    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(Long employeeId) {
        return employeeRepository.findById(employeeId);
    }

    @Transactional
    public Employee updateEmployee(Long id, Employee employeeToUpdate) {
        Employee employee = this.employeeRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("Employee not found with username: " + employeeToUpdate.getUsername()));
        employee.setFirstName(employeeToUpdate.getFirstName());
        employee.setLastName(employeeToUpdate.getLastName());
        employee.setUsername(employeeToUpdate.getUsername());
        return employeeRepository.save(employee);
    }

    @Transactional
    public Employee addNewEmployee(Employee employeeToAdd) {
        employeeToAdd.setPassword(this.passwordEncoder.encode(employeeToAdd.getPassword()));
        Role role = this.roleRepository.findByRole(UserRolesEnum.EMPLOYEE);
        employeeToAdd.setRoles(List.of(role));

        return this.employeeRepository.save(employeeToAdd);
    }


    @Transactional
    public void deleteById(Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    public List<Employee> findAllByLastNameAsc() {
        return employeeRepository.findAllByOrderByLastNameAsc();
    }
}
