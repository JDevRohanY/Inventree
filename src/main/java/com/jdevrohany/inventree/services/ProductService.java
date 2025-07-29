package com.jdevrohany.inventree.services;

import com.jdevrohany.inventree.models.Product;

import java.util.List;

public interface ProductService {
  public Product getSingleProduct(Long id);

  public Product createProduct(
      String title, String description, String image, String category, double price);

  public List<Product> getAllProducts();

  public Product deleteProduct(Long id);
}
