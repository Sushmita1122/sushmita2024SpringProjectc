package dev.sushmita.ProductService.mapper;

import dev.sushmita.ProductService.dto.CreateProductRequestDTO;
import dev.sushmita.ProductService.dto.ProductResponseDto;
import dev.sushmita.ProductService.entity.Product;

public class ProductEntityDTOMapper {


    public static ProductResponseDto convertProductEntityToProductResponseDTO(Product product){
        ProductResponseDto responseDTO=new ProductResponseDto();
//        responseDTO.setProductId(product.getId());
//        responseDTO.setCategory(product.getCategory());
        responseDTO.setRating(product.getRating());
        responseDTO.setPrice(product.getPrice());
        responseDTO.setTitle(product.getTitle());
        responseDTO.setImageURL(product.getImageURL());
        responseDTO.setDescription(product.getDescription());
        responseDTO.setCategory(product.getCategory().getName());
        return responseDTO;
    }
    public static  Product convertCreateProductRequestDTOToProduct(CreateProductRequestDTO productRequestDTO) {
        Product product = new Product();
        product.setRating(0);
        product.setPrice(productRequestDTO.getPrice());
        product.setTitle(productRequestDTO.getTitle());
        product.setImageURL(productRequestDTO.getImageURL());
        product.setDescription(productRequestDTO.getDescription());
      return product;

    }


}
