package com.dip.bootcamp.api.employee;

import com.dip.bootcamp.models.Employee;
import com.dip.bootcamp.services.EmployeeService;
import com.dip.bootcamp.viewmodels.AjaxResponseBody;
import com.dip.bootcamp.viewmodels.ResponseSave;
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

    @PostMapping(value = ("/save"))
    public AjaxResponseBody saveEmployee(@RequestBody Employee dataParam) {

        AjaxResponseBody responseBody = new AjaxResponseBody();

        ResponseSave save = employeeService.saveEmployee(dataParam);

        if (save.getErrorMsg().equalsIgnoreCase("-")) {
            responseBody.setStatusCode("201");
        } else {
            responseBody.setStatusCode("500");
        }
        responseBody.setMessage(save.getErrorMsg());

        return responseBody;
    }

    @PostMapping(value = ("/update"))
    public AjaxResponseBody updateEmployee(@RequestBody Employee dataParam) {

        AjaxResponseBody responseBody = new AjaxResponseBody();

        ResponseSave save = employeeService.updateEmployee(dataParam);

        if (save.getErrorMsg().equalsIgnoreCase("-")) {
            responseBody.setStatusCode("201");
        } else {
            responseBody.setStatusCode("500");
        }
        responseBody.setMessage(save.getErrorMsg());

        return responseBody;
    }

    @PostMapping(value = ("/delete"))
    public AjaxResponseBody deleteEmployee(@RequestBody Employee dataParam) {
        AjaxResponseBody responseBody = new AjaxResponseBody();

        ResponseSave delete = employeeService.deleteEmployee(dataParam);

        if (delete.getErrorMsg().equalsIgnoreCase("-")) {
            responseBody.setStatusCode("201");
        } else {
            responseBody.setStatusCode("500");
        }
        responseBody.setMessage(delete.getErrorMsg());
        return responseBody;
    }

}
