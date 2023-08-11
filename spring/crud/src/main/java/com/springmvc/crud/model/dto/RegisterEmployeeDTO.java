package com.springmvc.crud.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class RegisterEmployeeDTO {
    @NotBlank(message = "First name is required!")
    @Size(min = 2, message = "First Name must be at least 2 characters!")
    private String firstName;

    @NotBlank(message = "Last name is required!")
    @Size(min = 2, message = "Last Name must be at least 2 characters!")
    private String lastName;

    @NotBlank(message = "Username is required!")
    @Size(min = 5, message = "Username must be at least 5 characters")
    private String username;

    @NotBlank(message = "Password must not be blank!")
    @Size(min = 5, message = "Password must be at least 5!")
    private String password;

    @NotBlank(message = "Password must not be blank!")
    @Size(min = 5, message = "Password must be at least 5!")
    private String matchingPassword;

    public RegisterEmployeeDTO() {
    }

    public RegisterEmployeeDTO(String firstName, String lastName, String username, String password, String matchingPassword) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.matchingPassword = matchingPassword;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public RegisterEmployeeDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }
}
