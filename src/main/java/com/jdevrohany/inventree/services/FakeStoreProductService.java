package com.jdevrohany.inventree.services;

import com.jdevrohany.inventree.controller.ProductController;
import com.jdevrohany.inventree.dtos.FakeStoreProductDto;
import com.jdevrohany.inventree.models.Category;
import com.jdevrohany.inventree.models.Product;
import org.apache.logging.log4j.util.PropertiesUtil;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService {
  RestTemplate restTemplate;

  public FakeStoreProductService(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  @Override
  public Product getSingleProduct(Long id) {
    FakeStoreProductDto fakeStoreProductDto =
        restTemplate.getForObject(
            "https://fakestoreapi.com/products/" + id, FakeStoreProductDto.class);
    Product product = new Product();
    product.setTitle(fakeStoreProductDto.getTitle());
    product.setDescription(fakeStoreProductDto.getDescription());
    product.setImage(fakeStoreProductDto.getImage());
    product.setPrice(fakeStoreProductDto.getPrice());
    Category category = new Category();
    category.setTitle(fakeStoreProductDto.getCategory());

    return product;
  }

  @Override
  public Product createProduct(
      String title, String description, String image, String category, double price) {
    FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
    fakeStoreProductDto.setTitle(title);
    fakeStoreProductDto.setDescription(description);
    fakeStoreProductDto.setImage(image);
    fakeStoreProductDto.setCategory(category);
    fakeStoreProductDto.setPrice(price);

    FakeStoreProductDto response =
        restTemplate.postForObject(
            "https://fakestoreapi.com/products", fakeStoreProductDto, FakeStoreProductDto.class);
    return response.toProduct();
  }

  @Override
  public List<Product> getAllProducts() {
    FakeStoreProductDto[] fakeStoreProductDtos =
        restTemplate.getForObject("https://fakestoreapi.com/products", FakeStoreProductDto[].class);
    List<Product> products = new ArrayList<>();
    for (FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos) {
      products.add(fakeStoreProductDto.toProduct());
    }
    return products;
  }

  @Override
  public Product deleteProduct(Long id) {
    String url = "https://fakestoreapi.com/products/{id}";
    ResponseEntity<FakeStoreProductDto> responseEntity =
        restTemplate.exchange(url, HttpMethod.DELETE, null, FakeStoreProductDto.class, id);
    FakeStoreProductDto fakeStoreProductDto = responseEntity.getBody();
    return fakeStoreProductDto.toProduct();
  }
}
