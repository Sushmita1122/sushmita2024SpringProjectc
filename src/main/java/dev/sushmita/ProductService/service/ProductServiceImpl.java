package dev.sushmita.ProductService.service;

import dev.sushmita.ProductService.dto.FakeStoreProductResponseDTO;
import dev.sushmita.ProductService.entity.Product;
import dev.sushmita.ProductService.exception.ProductNotFoundException;
import dev.sushmita.ProductService.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("productServiceImpl")
public class ProductServiceImpl implements ProductService{
    @Autowired
    public ProductRepository productRepository;

    @Override
    public List<FakeStoreProductResponseDTO> getAllproducts() {
        return null;
    }

    @Override
    public FakeStoreProductResponseDTO getProduct(int productId) throws ProductNotFoundException {
        return null;
    }

    @Override
    public Product updateProduct(Product product, int productId) {
        return null;
    }

    @Override
    public boolean deleteProduct(int productId) {
        return false;
    }

    @Override
    public Product createProduct(Product product) {
        Product saveProduct = productRepository.save(product);
        return saveProduct;
    }
}
