package com.dip.bootcamp.services;

import com.dip.bootcamp.models.Product;
import com.dip.bootcamp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository repository;

    public List<Product> getAllProduct(Product dataParam) {
        return repository.listProduct(dataParam);
    }



}
