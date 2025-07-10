package com.jdevrohany.inventree.services;

import com.jdevrohany.inventree.dtos.FakeStoreProductDto;
import com.jdevrohany.inventree.models.Category;
import com.jdevrohany.inventree.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@Service
public class FakeStoreProductService implements ProductService{
    RestTemplate restTemplate;
    public FakeStoreProductService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }
    @Override
    public Product getSingleProduct(Long id) {
        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeStoreProductDto.class);
        Product product = new Product();
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setImage(fakeStoreProductDto.getImage());
        product.setPrice(fakeStoreProductDto.getPrice());
        Category category = new Category();
        category.setId("1");
        category.setName(fakeStoreProductDto.getCategory());

        return product;
    }

    @Override
    public Product createProduct(String title, String description, String image, String category, double price) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }
}
