package com.dip.bootcamp.controllers.employee;

import com.dip.bootcamp.models.Employee;
import com.dip.bootcamp.services.EmployeeService;
import com.dip.bootcamp.utilities.InformationConstant;
import com.dip.bootcamp.utilities.JsonHelper;
import com.dip.bootcamp.viewmodels.ResponseSave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping(value = ("/employee"))
public class EmployeeController {
    String title = "Employee" + InformationConstant.websiteTitle;

    @Autowired
    EmployeeService employeeService;

    @GetMapping(value = ("/list"))
    public String listEmployee(Model model) {

        Employee employeeParam = new Employee();

        List<Employee> data = employeeService.getAllEmployee(employeeParam);

        model.addAttribute("dataEmployee", data);
        model.addAttribute("username", "Nanra");
        model.addAttribute("title", title);

        return "employee/list";
    }

    @GetMapping(value = ("/list-datatables"))
    public String listEmployeeDt(Model model) {

        Employee employeeParam = new Employee();

        List<Employee> data = employeeService.getAllEmployee(employeeParam);


        model.addAttribute("dataEmployee", JsonHelper.toJsonString(data));
        model.addAttribute("username", "Nanra");
        model.addAttribute("title", title);

        return "employee/list2";
    }

    @GetMapping(value = ("/add-employee"))
    public String newEmployee(Model model) {
        String titleCard = "Add Employee";

        model.addAttribute("username", "Nanra");
        model.addAttribute("titleCard", titleCard);
        model.addAttribute("title", title);
        model.addAttribute("dataEmployee", new Employee());

        return "employee/form-employee";
    }

    @GetMapping(value = ("/edit-employee"))
    public String editEmployee(@RequestParam String idEmployee, Model model) {
        String titleCard = "Edit Employee";

        // Set Parameter for Filtering
        Employee employeeParam = new Employee();
        employeeParam.setId(Integer.parseInt(idEmployee));

        // Get Data From Service
        Employee data = employeeService.getAllEmployee(employeeParam).get(0);

        // Set Model For View Attributes
        model.addAttribute("dataEmployee", data);
        model.addAttribute("titleCard", titleCard);
        model.addAttribute("title", title);
        model.addAttribute("username", "Nanra");

        return "employee/form-employee";
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
