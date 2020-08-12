package com.dip.bootcamp.controllers;

import com.dip.bootcamp.utilities.InformationConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@Controller
@RequestMapping(value = "/dashboard")
public class HomePageController {

    @GetMapping(value = (""))
    public String dashboard(Model model){
        String pageTitle = "Dashboard" + InformationConstant.websiteTitle;

        model.addAttribute("username", "Nanra");
        model.addAttribute("title", pageTitle);
        return "dashboard";
    }

    @GetMapping(value = "/detail-visitor")
    public ResponseEntity dashboardDetailVisitor(){
        return ResponseEntity.ok("This is Page Detail Visitor");
    }

}
