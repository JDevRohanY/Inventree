package com.jdevrohany.inventree.dtos;

import com.jdevrohany.inventree.models.Category;

public class CreateProductRequestDto {
    private String title;
    private String description;
    private String image;
    private double price;
    private String category;

    public void setTitle(String title){
        this.title = title;
    }

    public String getTitle(){
        return this.title;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getDescription(){
        return this.description;
    }

    public void setImage(String image){
        this.image = image;
    }

    public String getImage(){
        return this.image;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public double getPrice(){
        return this.price;
    }

    public void setCategory(String category){
        this.category = category;
    }

    public String getCategory(){
        return this.category;
    }
}
