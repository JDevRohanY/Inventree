package com.jdevrohany.inventree.controller;

import com.jdevrohany.inventree.models.Product;
import com.jdevrohany.inventree.services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/product/{id}")
    public Product getProduct(@PathVariable("id") Long id){
        return productService.getSingleProduct(id);
    }

    public void getAllProducts(){

    }

    public void createProduct(){

    }

    public void deleteProduct(){

    }
}
