package com.dip.bootcamp.controllers.employee;

import com.dip.bootcamp.models.Employee;
import com.dip.bootcamp.services.EmployeeService;
import com.dip.bootcamp.utilities.InformationConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = ("/api/employee"))
public class EmployeeApi {

    @Autowired
    EmployeeService employeeService;

    @GetMapping(value = ("/list"))
    public List<Employee> listEmployeeApi() {
        Employee employeeParam = new Employee();
        List<Employee> data = employeeService.getAllEmployee(employeeParam);
        System.out.println(data);
        return data;
    }

}
