package com.springmvc.crud.service;

import com.springmvc.crud.model.entity.Employee;
import com.springmvc.crud.model.entity.Role;
import com.springmvc.crud.model.user.EmployeeUserDetails;
import com.springmvc.crud.repository.EmployeeRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class EmployeeUserDetailsService implements UserDetailsService {
    private final EmployeeRepository employeeRepository;

    public EmployeeUserDetailsService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Employee> employee = this.employeeRepository.findByUsername(username);
        return employee.map(this::mapToUserDetails)
                .orElseThrow(() -> new UsernameNotFoundException("There is no present user with this username"));
    }

    private UserDetails mapToUserDetails(Employee employee) {
        return new EmployeeUserDetails(
                employee.getFirstName(),
                employee.getLastName(),
                employee.getUsername(),
                employee.getPassword(),
                employee.getRoles()
                        .stream()
                        .map(this::mapAuthorities)
                        .toList());
    }

    private GrantedAuthority mapAuthorities(Role role) {
        return new SimpleGrantedAuthority("ROLE_" + role.getRole().name());
    }
}
