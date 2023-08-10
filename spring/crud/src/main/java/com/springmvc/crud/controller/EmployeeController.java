package com.springmvc.crud.controller;

import com.springmvc.crud.entity.Employee;
import com.springmvc.crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.save(employee);
        return "redirect:/employees/list";
    }

    @GetMapping("/update")
    public String updateEmployee(@RequestParam("employeeId") int id,
                                 Model model) {
        Optional<Employee> employee = employeeService.getEmployeeById(id);

        model.addAttribute("employee", employee);

        return "employees/employee-form";
    }

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("employeeId") int id) {
        employeeService.deleteById(id);
        return "redirect:/employees/list";
    }
}