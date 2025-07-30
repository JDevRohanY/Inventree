package com.jdevrohany.inventree.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BulkCreateProductRequestDto {
    private List<CreateProductRequestDto> products;
}
