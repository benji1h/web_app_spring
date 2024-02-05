package com.example.webapp.controller;

import com.example.webapp.model.Employee;
import com.example.webapp.repository.EmployeeProxy;
import com.example.webapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeService service;

    @GetMapping("/")
    public String home(Model model){
        try {


            Iterable<Employee> listEmployee = service.getEmployees();
            model.addAttribute("employees", listEmployee);
            return "home";

        }catch (Exception e){
            //e.printStackTrace();
            return "help";
        }

    }
}
