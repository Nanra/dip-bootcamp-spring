package com.dip.bootcamp.api.product;

import com.dip.bootcamp.models.Product;
import com.dip.bootcamp.services.ProductService;
import com.dip.bootcamp.utilities.InformationConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = ("/api/product"))
public class ProductApi {

    @Autowired
    ProductService productService;

    @GetMapping(value = ("/list"))
    public List<Product> listProduct(Model model){
        return productService.getAllProduct(new Product());
    }

}
