package com.dip.bootcamp.controllers.employee;

import com.dip.bootcamp.models.Employee;
import com.dip.bootcamp.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = ("/api/employee"))
public class EmployeeApi {

    @Autowired
    EmployeeService employeeService;

    @PostMapping(value = ("/search"))
    public List<Employee> searchEmployeeApi(@RequestBody Employee dataParam) {
        return employeeService.getAllEmployee(dataParam);
    }

    @GetMapping(value = ("/list"))
    public List<Employee> listEmployeeApi() {
        return employeeService.getAllEmployee(new Employee());
    }

}
