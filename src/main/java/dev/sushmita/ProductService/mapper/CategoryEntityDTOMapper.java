package dev.sushmita.ProductService.mapper;

import dev.sushmita.ProductService.dto.CategoryResponseDTO;
import dev.sushmita.ProductService.dto.CreateCategoryRequestDTO;
import dev.sushmita.ProductService.dto.ProductResponseDto;
import dev.sushmita.ProductService.entity.Category;
import dev.sushmita.ProductService.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class CategoryEntityDTOMapper {

    public static CategoryResponseDTO convertCategoryToCategoryResponseDTO(Category category){
        CategoryResponseDTO categoryResponseDTO = new CategoryResponseDTO();
        categoryResponseDTO.setCategoryName(category.getName());
        List<ProductResponseDto> productResponseDtos = new ArrayList<>();
        if(!(category.getProducts() == null || category.getProducts().isEmpty())){
            for(Product product : category.getProducts()){
                productResponseDtos.add(ProductEntityDTOMapper.convertProductEntityToProductResponseDTO(product));
            }
        }
        categoryResponseDTO.setAllProduct(productResponseDtos);
        return categoryResponseDTO;
    }

    public static Category convertCreateCategoryDTOToCategory (CreateCategoryRequestDTO createCategoryRequestDTO){
        Category category = new Category();
        category.setName(createCategoryRequestDTO.getCategoryName());
        return category;
    }
}
