package com.dip.bootcamp.controllers;

import com.dip.bootcamp.models.Login;
import com.dip.bootcamp.utilities.InformationConstant;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class LoginController {

    @RequestMapping(value = {"/", "/login"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String loginPage(Model model, @ModelAttribute("dataLogin") Login dataLogin){
        String pageTitle = "Login" + InformationConstant.websiteTitle;

        model.addAttribute("title", pageTitle);
        return "login";
    }

    @RequestMapping(value = {"/validate-login"}, method = {RequestMethod.GET, RequestMethod.POST})
    public RedirectView loginValidation(@ModelAttribute("dataLogin") Login dataLogin, Model model){

        if (dataLogin.getUsername().equalsIgnoreCase("Nanra")
                && dataLogin.getPassword().equalsIgnoreCase("password")) {

            System.out.println("Authenticated");

            return new RedirectView("/dashboard");
        } else {
            System.out.println("UnAuthenticated");
            return new RedirectView("/login");
        }


    }

}
