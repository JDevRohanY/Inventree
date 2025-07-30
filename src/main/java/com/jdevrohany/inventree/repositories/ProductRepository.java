package com.jdevrohany.inventree.repositories;

import com.jdevrohany.inventree.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//JPARepository take two params, <table, data type of primary key>
public interface ProductRepository extends JpaRepository<Product, Long> {
    //This is a jpa query to save the data and will be used for creating data in database
    Product save(Product entity);

    Product findByIdIs(Long id);
    List<Product> findAll();

    void deleteById(Long id);
}
