package com.dip.bootcamp.controllers;

import com.dip.bootcamp.models.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = ("/employee"))
public class EmployeeController {

    @GetMapping(value = ("/list"))
    public ResponseEntity<?> homePage() {

        Employee dataEmployee = new Employee();
        dataEmployee.setId(7);
        dataEmployee.setName("Nanra Sukedy");
        dataEmployee.setEmail("nanrasukedy@outlook.com");
        dataEmployee.setPhone("08123456789");
        dataEmployee.setAddress("Bandung");

        return ResponseEntity.ok(dataEmployee);
    }


}
