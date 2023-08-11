package com.springmvc.crud.controller;

import com.springmvc.crud.model.dto.RegisterEmployeeDTO;
import com.springmvc.crud.model.entity.Employee;
import com.springmvc.crud.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RegisterController {
    private final EmployeeService employeeService;

    public RegisterController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @ModelAttribute("registerEmployeeDTO")
    public RegisterEmployeeDTO registerEmployeeDTO(){
        return new RegisterEmployeeDTO();
    }

    @GetMapping("/register")
    public String register() {
        return "register-page";
    }

    @PostMapping("/register")
    public String register(@Valid RegisterEmployeeDTO registerEmployeeDTO,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("registerEmployeeDTO", registerEmployeeDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addEmployeeDto", bindingResult);
            return "redirect:/register";
        }
        this.employeeService.register(registerEmployeeDTO);
        return "redirect:/employees/list";
    }
}
