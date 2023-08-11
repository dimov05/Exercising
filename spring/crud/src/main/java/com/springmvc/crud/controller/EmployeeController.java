package com.springmvc.crud.controller;

import com.springmvc.crud.model.entity.Employee;
import com.springmvc.crud.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String listEmployees(Model theModel) {
        List<Employee> employeeList = employeeService.findAllByLastNameAsc();
        // add to the spring model
        theModel.addAttribute("employees", employeeList);

        return "employees/list-employees";
    }

    @GetMapping("/add")
    public String addEmployee(Model model) {
        Employee employeeToAdd = new Employee();
        model.addAttribute("employee", employeeToAdd);
        return "employees/employee-form";
    }

    @PostMapping("/add")
    public String updateEmployee(@Valid @ModelAttribute("employee") Employee employee,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("employee", employee);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addEmployeeDto", bindingResult);
            return "redirect:/employees/list";
        }
        employeeService.addNewEmployee(employee);
        return "redirect:/employees/list";
    }

    @GetMapping("/update/{id}")
    public String updateEmployee(@PathVariable("employeeId") Long id,
                                 Model model) {
        Optional<Employee> employee = employeeService.getEmployeeById(id);

        model.addAttribute("employee", employee);

        return "employees/employee-form";
    }
    @PostMapping("/update/{id}")
    public String updateEmployee(@PathVariable Long id,
                                 @Valid @ModelAttribute Employee employee,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("employee", employee);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.updateEmployeeDto", bindingResult);

            return "redirect:/employees/update/" + id;
        }
        this.employeeService.updateEmployee(id,employee);
        return "redirect:/employees/list";
    }

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("employeeId") Long id) {
        employeeService.deleteById(id);
        return "redirect:/employees/list";
    }
}