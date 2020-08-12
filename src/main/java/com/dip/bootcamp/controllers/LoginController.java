package com.dip.bootcamp.controllers;

import com.dip.bootcamp.viewmodels.LoginRequest;
import com.dip.bootcamp.utilities.InformationConstant;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class LoginController {

    @RequestMapping(value = {"/", "/login"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String loginPage(Model model, @ModelAttribute("dataLoginRequest") LoginRequest dataLoginRequest){
        String pageTitle = "Login" + InformationConstant.websiteTitle;

        model.addAttribute("title", pageTitle);
        return "login";
    }

    @RequestMapping(value = {"/validate-login"}, method = {RequestMethod.GET, RequestMethod.POST})
    public RedirectView loginValidation(@ModelAttribute("dataLoginRequest") LoginRequest dataLoginRequest, Model model){

        if (dataLoginRequest.getUsername().equalsIgnoreCase("Nanra")
                && dataLoginRequest.getPassword().equalsIgnoreCase("password")) {

            System.out.println("Authenticated");

            return new RedirectView("/dashboard");
        } else {
            System.out.println("UnAuthenticated");
            return new RedirectView("/login");
        }


    }

}
