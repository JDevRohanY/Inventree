package com.jdevrohany.inventree.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDto {
    Integer id;
    String title;
    Float price;
    String description;
    String category;
    String image;
}
