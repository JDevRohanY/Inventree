package com.jdevrohany.inventree.services;

import com.jdevrohany.inventree.models.Category;
import com.jdevrohany.inventree.models.Product;
import com.jdevrohany.inventree.repositories.CategoryRepository;
import com.jdevrohany.inventree.repositories.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("selfProductService")
public class SelfProductService implements ProductService{

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getSingleProduct(Long id) {
        return productRepository.findByIdIs(id);
    }

    @Override
    public Product createProduct(String title, String description, String image, String category, double price) {
        //Create a new product
        Product product = new Product();
        product.setTitle(title);
        product.setDescription(description);
        product.setImage(image);
        product.setPrice(price);
        //First check whether category exist or not
        Category categoryFromDatabase = categoryRepository.findByTitle(category);
        if(categoryFromDatabase == null){
            //Create a new category
            Category newCategory = new Category();
            newCategory.setTitle(category);
            categoryFromDatabase = newCategory;
            categoryRepository.save(newCategory);
        }
        product.setCategory(categoryFromDatabase);
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product deleteProduct(Long id) {
        Product product = productRepository.findByIdIs(id);
        if(product == null){
            throw new EntityNotFoundException("Product with ID " + id + " not found");
        }
        productRepository.deleteById(id);
        return product;
    }
}
