package com.jdevrohany.inventree.controller;

import com.jdevrohany.inventree.dtos.BulkCreateProductRequestDto;
import com.jdevrohany.inventree.dtos.CreateProductRequestDto;
import com.jdevrohany.inventree.models.Product;
import com.jdevrohany.inventree.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {
  ProductService productService;

  public ProductController(@Qualifier("selfProductService") ProductService productService) {
    this.productService = productService;
  }

  @GetMapping("/product/{id}")
  public Product getProduct(@PathVariable("id") Long id) {
    return productService.getSingleProduct(id);
  }

  // This api will not take any params nor request body
  // Response entity contains everything that a response required (header, status, body)
  @GetMapping("/products")
  public ResponseEntity<List<Product>> getAllProducts() {
    // Fill Response entity body
    List<Product> responseData = productService.getAllProducts();
    return new ResponseEntity<>(responseData, HttpStatusCode.valueOf(202));
  }

  // Create a dto specific to product controller
  @PostMapping("/product")
  public Product createProduct(@RequestBody CreateProductRequestDto createProductRequestDto) {
    return productService.createProduct(
        createProductRequestDto.getTitle(),
        createProductRequestDto.getDescription(),
        createProductRequestDto.getImage(),
        createProductRequestDto.getCategory(),
        createProductRequestDto.getPrice());
  }

  @DeleteMapping("/product/{id}")
  public ResponseEntity<Product> deleteProduct(@PathVariable("id") Long id) {
    Product productResponse = productService.deleteProduct(id);
    return ResponseEntity.ok(productResponse);
  }

  @PostMapping("/products/bulk")
  public List<Product> createProduct(
      @RequestBody BulkCreateProductRequestDto requestDto) {
    List<Product> createProducts = new ArrayList<>();
    for (CreateProductRequestDto dto : requestDto.getProducts()) {
      Product product =
          productService.createProduct(
              dto.getTitle(),
              dto.getDescription(),
              dto.getImage(),
              dto.getCategory(),
              dto.getPrice());
      createProducts.add(product);
    }
    return createProducts;
  }
}
