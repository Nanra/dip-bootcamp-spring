package com.dip.bootcamp.controllers.employee;

import com.dip.bootcamp.models.Employee;
import com.dip.bootcamp.services.EmployeeService;
import com.dip.bootcamp.utilities.InformationConstant;
import com.dip.bootcamp.viewmodels.ResponseSave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

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

    @GetMapping(value = ("/new-employee"))
    public String newEmployee(@ModelAttribute("dataInput") Employee dataEmployee, Model model) {
        return "employee/new-employee";
    }

    @PostMapping(value = ("/save-employee"))
    public RedirectView saveEmployee(@ModelAttribute("dataInput") Employee dataEmployee, Model model) {

        System.out.println(dataEmployee.getName());
        System.out.println(dataEmployee.getEmail());
        System.out.println(dataEmployee.getPhone());
        System.out.println(dataEmployee.getAddress());

       ResponseSave save = employeeService.saveEmployee(dataEmployee);

       if (save.errorMsg.equalsIgnoreCase("-")){
           return new RedirectView("/employee/list");
       } else {
           return new RedirectView("/employee/new-employee");
       }


    }
}
