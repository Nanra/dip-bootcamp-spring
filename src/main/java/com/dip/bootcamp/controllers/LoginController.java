package com.dip.bootcamp.controllers;

import com.dip.bootcamp.utilities.InformationConstant;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
    public String index(Model model){
        String pageTitle = "Login" + InformationConstant.websiteTitle;

        model.addAttribute("title", pageTitle);
        return "login";
    }

}
