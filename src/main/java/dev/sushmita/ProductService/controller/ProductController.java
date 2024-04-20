package dev.sushmita.ProductService.controller;

import dev.sushmita.ProductService.dto.FakeStoreProductResponseDTO;
import dev.sushmita.ProductService.entity.Product;
import dev.sushmita.ProductService.exception.RandomException;
import dev.sushmita.ProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    @Qualifier("productServiceImpl")
    private ProductService productService;

    @GetMapping("/product")
    public ResponseEntity getAllProducts() {
        List<FakeStoreProductResponseDTO> product = productService.getAllproducts();
        return ResponseEntity.ok(product);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity getProductById(@PathVariable("id") int id) {
        FakeStoreProductResponseDTO productByid = productService.getProduct(id);
        return ResponseEntity.ok(productByid);

    }

    @GetMapping("/productException")
    public ResponseEntity getProductException() {
        throw new RandomException("Exception From Product");

    }

    @PostMapping("/createProduct")
    public ResponseEntity createProduct(@RequestBody Product product) {
        Product saveProduct = productService.createProduct(product);
        return ResponseEntity.ok(saveProduct);
    }
}