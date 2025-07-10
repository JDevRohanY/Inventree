package com.jdevrohany.inventree.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    String title;
    String description;
    String image;
    double price;
    Category category;
}
