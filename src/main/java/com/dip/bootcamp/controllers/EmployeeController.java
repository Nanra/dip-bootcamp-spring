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
    public String listEmployee(Model model) {

        Employee dataEmployee = new Employee();
        Employee employeeParam = new Employee();

        List<Employee> data = employeeService.getAllEmployee(employeeParam);

        dataEmployee.setId(7);
        dataEmployee.setName("Nanra Sukedy");
        dataEmployee.setEmail("nanrasukedy@outlook.com");
        dataEmployee.setPhone("08123456789");
        dataEmployee.setAddress("Bandung");

        model.addAttribute("name", dataEmployee.getName());
        model.addAttribute("address", dataEmployee.getAddress());
        model.addAttribute("email", dataEmployee.getEmail());
        model.addAttribute("phone", dataEmployee.getPhone());

        System.out.println(data);

        return "/employee/list";
    }


}
