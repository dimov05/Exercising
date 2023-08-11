package com.springmvc.crud.config;

import com.springmvc.crud.repository.EmployeeRepository;
import com.springmvc.crud.service.EmployeeUserDetailsService;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {
    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails john = User.builder()
                .username("john")
                .password("{noop}1234")
                .roles("EMPLOYEE")
                .build();
        UserDetails marry = User.builder()
                .username("marry")
                .password("{noop}1234")
                .roles("EMPLOYEE", "MANAGER")
                .build();
        UserDetails susan = User.builder()
                .username("susan")
                .password("{noop}1234")
                .roles("EMPLOYEE", "MANAGER", "ADMIN")
                .build();
        return new InMemoryUserDetailsManager(john, marry, susan);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth ->
                        auth
                                .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                                .requestMatchers("/login", "/register").permitAll()
                                .requestMatchers("/employees/add", "/employees/update/**").hasRole("MANAGER")
                                .requestMatchers("/employees/delete/**").hasRole("ADMIN")
                                .anyRequest().authenticated())
                // Login configuration
                .formLogin(form ->
                        form
                                .loginPage("/login")
                                .defaultSuccessUrl("/employees/list", true)
                                .permitAll())
                .logout(LogoutConfigurer::permitAll);
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(EmployeeRepository employeeRepository) {
        return new EmployeeUserDetailsService(employeeRepository);
    }

//    public UserDetailsManager userDetailsManager(DataSource dataSource) {
//        @Bean
//        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);
//
//        userDetailsManager
//                .setUsersByUsernameQuery("select id, first_name,last_name,password,username from employee where id=?");
//        userDetailsManager
//                .setAuthoritiesByUsernameQuery("select id,role from  where id=?");
//        return userDetailsManager;
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
