package dev.sushmita.ProductService.controller;

import dev.sushmita.ProductService.dto.CategoryResponseDTO;
import dev.sushmita.ProductService.dto.CreateCategoryRequestDTO;
import dev.sushmita.ProductService.entity.Category;
import dev.sushmita.ProductService.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/category")
@Qualifier("categoryServiceImpl")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping
    public ResponseEntity<List<CategoryResponseDTO>> getAllCategories(){
    return ResponseEntity.ok(categoryService.getAllCategories());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponseDTO> getCategoryById(@PathVariable("id") UUID categoryId){
        return ResponseEntity.ok(categoryService.getCategory(categoryId));
    }

    @PostMapping
    public ResponseEntity<CategoryResponseDTO> createCategory(@RequestBody CreateCategoryRequestDTO createCategoryRequestDTO){
    return ResponseEntity.ok(categoryService.createCategory(createCategoryRequestDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponseDTO> updateCategory(@PathVariable("id") UUID categoryId, @RequestBody CreateCategoryRequestDTO createCategoryRequestDTO){
    return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteCategory(@PathVariable("id") UUID categoryId){
        return ResponseEntity.ok(categoryService.deleteCategory(categoryId));
    }
}
