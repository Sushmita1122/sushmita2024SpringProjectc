package dev.sushmita.ProductService.mapper;

import dev.sushmita.ProductService.dto.ProductResponseDto;
import dev.sushmita.ProductService.entity.Product;

public class ProductEntityDTOMapper {


    public static ProductResponseDto convertProductEntityToProductResponseDTO(Product product){
        ProductResponseDto responseDTO=new ProductResponseDto();
//        responseDTO.setProductId(product.getId());
        responseDTO.setCategory(product.getCategory());
        responseDTO.setRating(product.getRating());
        responseDTO.setPrice(product.getPrice());
        responseDTO.setTitle(product.getTitle());
        responseDTO.setImageURL(product.getImageURL());
        responseDTO.setDescription(product.getDescription());
        return responseDTO;
    }
}
