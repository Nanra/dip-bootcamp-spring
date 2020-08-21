package com.dip.bootcamp.controllers.product;

import com.dip.bootcamp.models.Product;
import com.dip.bootcamp.services.ProductService;
import com.dip.bootcamp.utilities.InformationConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = ("/product"))
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping(value = ("/list"))
    public String listProduct(Model model){

        String titlePage = "Product" + InformationConstant.websiteTitle;

//        List<Product> data = productService.getAllProduct(new Product());

        model.addAttribute("title", titlePage);
//        model.addAttribute("dataProduct", titlePage);
        model.addAttribute("username", "Nanra");

        return "product/list";
    }


}
