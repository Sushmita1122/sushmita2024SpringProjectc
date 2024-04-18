package dev.sushmita.ProductService.service;

import dev.sushmita.ProductService.dto.FakeStoreProductResponseDTO;
import dev.sushmita.ProductService.entity.Product;
import dev.sushmita.ProductService.exception.ProductNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    List<FakeStoreProductResponseDTO> getAllproducts();
    FakeStoreProductResponseDTO getProduct(int productId) throws ProductNotFoundException;
    Product updateProduct(Product product, int productId);
    boolean deleteProduct(int productId);
    Product createProduct(Product product);
}
