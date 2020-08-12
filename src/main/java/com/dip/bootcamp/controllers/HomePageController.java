package com.dip.bootcamp.controllers;

import com.dip.bootcamp.utilities.InformationConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@Controller
public class HomePageController {

    @RequestMapping(value = "/dashboard", method = {RequestMethod.GET, RequestMethod.POST})
    public String dashboard(Model model){
        String pageTitle = "Dashboard" + InformationConstant.websiteTitle;

        model.addAttribute("username", "Nanra");
        model.addAttribute("title", pageTitle);
        return "dashboard";
    }

}
