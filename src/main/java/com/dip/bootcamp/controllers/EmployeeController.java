package com.dip.bootcamp.controllers;

import com.dip.bootcamp.models.Employee;
import com.dip.bootcamp.services.EmployeeService;
import com.dip.bootcamp.utilities.InformationConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = ("/employee"))
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping(value = ("/list"))
    public String listEmployee(Model model) {

        Employee employeeParam = new Employee();
        String title = "Employee" + InformationConstant.websiteTitle;


        List<Employee> data = employeeService.getAllEmployee(employeeParam);

        System.out.println(data);

        model.addAttribute("dataEmployee", data);
        model.addAttribute("title", title);

        return "employee/list";
    }

    @GetMapping(value = ("/list-role"))
    public String listRoleEmployee(Model model) {

        String titlePage = "Employee Role";
        String userName = "Admin";

        model.addAttribute("title", titlePage);
        model.addAttribute("user", userName);

        return "employee/list-role";
    }
}
