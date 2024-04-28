package dev.sushmita.ProductService.service;

import dev.sushmita.ProductService.dto.CategoryResponseDTO;
import dev.sushmita.ProductService.dto.CreateCategoryRequestDTO;
import dev.sushmita.ProductService.entity.Category;
import dev.sushmita.ProductService.entity.Product;
import dev.sushmita.ProductService.exception.CategoryNotFoundException;
import dev.sushmita.ProductService.exception.ProductNotFoundException;
import dev.sushmita.ProductService.mapper.CategoryEntityDTOMapper;
import dev.sushmita.ProductService.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public CategoryResponseDTO getCategory(UUID categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(
                ()-> new CategoryNotFoundException("category id not found" + categoryId)
        );

        return CategoryEntityDTOMapper.convertCategoryToCategoryResponseDTO(category);
    }

    @Override
    public List<CategoryResponseDTO> getAllCategories() {
        List<Category> saveCategory = categoryRepository.findAll();
        List<CategoryResponseDTO> categoryResponseDTOS = new ArrayList<>();
        for(Category category : saveCategory){
            categoryResponseDTOS.add(CategoryEntityDTOMapper.convertCategoryToCategoryResponseDTO(category));
        }
        return categoryResponseDTOS;
    }

    @Override
    public CategoryResponseDTO createCategory(CreateCategoryRequestDTO categoryRequestDTO) {
    Category category = CategoryEntityDTOMapper.convertCreateCategoryDTOToCategory(categoryRequestDTO);
        category = categoryRepository.save(category);
        return CategoryEntityDTOMapper.convertCategoryToCategoryResponseDTO(category);
    }

    @Override
    public CategoryResponseDTO updateCategory(CreateCategoryRequestDTO categoryRequestDTO, UUID categoryId) {
        return null;
    }

    @Override
    public boolean deleteCategory(UUID categoryId) {
        categoryRepository.deleteById(categoryId);
        return true;
    }
}
