package com.dip.bootcamp.controllers;

import com.dip.bootcamp.models.Employee;
import com.dip.bootcamp.services.EmployeeService;
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
    public String listEmployee() {

        Employee employeeParam = new Employee();

        List<Employee> data = employeeService.getAllEmployee(employeeParam);

        System.out.println(data);

//        return ResponseEntity.ok().body(data);
        return "employee/list";
    }
}
