package com.jdevrohany.inventree.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Category extends BaseModel {
    private String title;

    //Inside mappedBy the value in double colon should be variable name not datatype
    @OneToMany(mappedBy = "category")
    @JsonIgnore
    private List<Product> productList;
}

