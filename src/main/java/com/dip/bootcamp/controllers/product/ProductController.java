package com.dip.bootcamp.controllers.product;

import com.dip.bootcamp.utilities.InformationConstant;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = ("/product"))
public class ProductController {

    @GetMapping(value = ("/list"))
    public String listProduct(Model model){

        String titlePage = "Product" + InformationConstant.websiteTitle;

        model.addAttribute("title", titlePage);
        model.addAttribute("username", "Nanra");

        return "product/list";
    }


}
