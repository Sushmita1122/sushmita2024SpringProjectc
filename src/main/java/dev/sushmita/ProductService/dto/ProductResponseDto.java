package dev.sushmita.ProductService.dto;

import dev.sushmita.ProductService.entity.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseDto {
    private int productId;
    private String title;
    private double price;
    private String description;
    private String category;
    private String imageURL;
    private double rating;

}
