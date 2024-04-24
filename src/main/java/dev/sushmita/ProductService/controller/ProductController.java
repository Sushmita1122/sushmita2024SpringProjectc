package dev.sushmita.ProductService.controller;

import dev.sushmita.ProductService.dto.CreateProductRequestDTO;
import dev.sushmita.ProductService.dto.FakeStoreProductResponseDTO;
import dev.sushmita.ProductService.dto.ProductResponseDto;
import dev.sushmita.ProductService.entity.Product;
import dev.sushmita.ProductService.exception.RandomException;
import dev.sushmita.ProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class ProductController {

    @Autowired
    @Qualifier("productServiceImpl")
    private ProductService productService;

    @GetMapping("/product")
    public ResponseEntity<List<ProductResponseDto>> getAllProducts() {
        List<ProductResponseDto> product = productService.getAllproducts();
        return ResponseEntity.ok(product);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<ProductResponseDto> getProductById(@PathVariable("id") UUID id) {
//        ProductResponseDto  productByid = productService.getProduct(id);
        return ResponseEntity.ok(productService.getProduct(id));

    }
    @GetMapping("/name/{productName}")
    public ResponseEntity getProductById(@PathVariable("productName") String productName) {
        return ResponseEntity.ok(productService.findByproductName(productName));
    }

    @GetMapping("/productException")
    public ResponseEntity getProductException() {
        throw new RandomException("Exception From Product");

    }

    @PostMapping("/createProduct")
    public ResponseEntity<ProductResponseDto> createProduct(@RequestBody CreateProductRequestDTO product) {
        return ResponseEntity.ok(productService.createProduct(product));

    }
    @DeleteMapping("/deleteProduct/{id}")
    public ResponseEntity<Boolean> deleteProduct(@PathVariable ("id") UUID id) {
      return ResponseEntity.ok(productService.deleteProduct(id));
    }
    @PutMapping("/updateProduct/{id}")
    public ResponseEntity<ProductResponseDto> updateProduct(@RequestBody CreateProductRequestDTO productRequestDTO, @PathVariable ("id") UUID id){
        return ResponseEntity.ok(productService.updateProduct(productRequestDTO , id));

    }

}