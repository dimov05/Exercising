package com.springmvc.crud.controller;

import com.springmvc.crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login-page";
    }

    @PostMapping("/login-error")
    public String onFailedLogin(@ModelAttribute("username") String username,
                                RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("username", username);
        redirectAttributes.addFlashAttribute("bad_credentials", true);

        return "redirect:/login";
    }
}
