package dev.sushmita.ProductService.service;

import dev.sushmita.ProductService.dto.CreateProductRequestDTO;
import dev.sushmita.ProductService.dto.FakeStoreProductResponseDTO;
import dev.sushmita.ProductService.dto.ProductResponseDto;
import dev.sushmita.ProductService.entity.Product;
import dev.sushmita.ProductService.exception.ProductNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface ProductService {
    List<ProductResponseDto> getAllproducts();
    ProductResponseDto getProduct(UUID productId) throws ProductNotFoundException;
    ProductResponseDto updateProduct(CreateProductRequestDTO product, UUID productId);
    boolean deleteProduct(UUID productId);
    ProductResponseDto createProduct(CreateProductRequestDTO product);
    ProductResponseDto findByproductName(String productName);
}
