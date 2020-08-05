package com.dip.bootcamp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@Controller
public class HomePageController {

    private String appMode;

    @Autowired
    public HomePageController(Environment environment){
        appMode = environment.getProperty("app-mode");
    }

    @RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.POST})
    public String index(Model model){
        model.addAttribute("datetime", new Date());
        model.addAttribute("username", "Nanra");
//        model.addAttribute("mode", appMode);
        return "index";
    }

    @RequestMapping(value = "/dashboard", method = {RequestMethod.GET, RequestMethod.POST})
    public String dashboard(Model model){
        return "dashboard";
    }

}
