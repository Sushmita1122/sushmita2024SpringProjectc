package dev.sushmita.ProductService.service;

import dev.sushmita.ProductService.dto.CreateProductRequestDTO;
import dev.sushmita.ProductService.dto.FakeStoreProductResponseDTO;
import dev.sushmita.ProductService.dto.ProductResponseDto;
import dev.sushmita.ProductService.entity.Category;
import dev.sushmita.ProductService.entity.Product;
import dev.sushmita.ProductService.exception.CategoryNotFoundException;
import dev.sushmita.ProductService.exception.ProductNotFoundException;
import dev.sushmita.ProductService.mapper.ProductEntityDTOMapper;
import dev.sushmita.ProductService.repository.CategoryRepository;
import dev.sushmita.ProductService.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service("productServiceImpl")
public class ProductServiceImpl implements ProductService{
    @Autowired
    public ProductRepository productRepository;
//    CategoryRepository
@Autowired
public CategoryRepository categoryRepository;

    @Override
    public List<ProductResponseDto> getAllproducts() {
        List<Product> savedProduct = productRepository.findAll();
        List<ProductResponseDto> productResponseDtos = new ArrayList<>();
        for(Product product : savedProduct){
            productResponseDtos.add
                    (ProductEntityDTOMapper.convertProductEntityToProductResponseDTO(product));
        }
        return productResponseDtos;
    }

    @Override
    public ProductResponseDto getProduct(UUID productId) throws ProductNotFoundException {
//        Product saveProduct = productRepository.findById(productId).get();
//        if(saveProduct == null){
//            throw new ProductNotFoundException
//                    ("product not found for id:" + productId);
//        }
//        return saveProduct;
        Product product = productRepository.findById(productId).orElseThrow(
                ()-> new ProductNotFoundException("product not found for id" + productId)
        );
//        return saveProduct;
        return ProductEntityDTOMapper.convertProductEntityToProductResponseDTO(product);
    }

    @Override
    public ProductResponseDto updateProduct(CreateProductRequestDTO createProductRequestDTO, UUID productId) {
        Product saveProduct = productRepository.findById(productId).orElseThrow(
                ()-> new ProductNotFoundException("product not found for id" + productId)
        );
        saveProduct.setTitle(createProductRequestDTO.getTitle());
        saveProduct.setRating(createProductRequestDTO.getRating());
        saveProduct.setDescription(createProductRequestDTO.getDescription());
        saveProduct.setImageURL(createProductRequestDTO.getImageURL());
        saveProduct.setPrice(createProductRequestDTO.getPrice());
        saveProduct = productRepository.save(saveProduct);
        return ProductEntityDTOMapper.convertProductEntityToProductResponseDTO(saveProduct);

    }



    @Override
    public ProductResponseDto createProduct(CreateProductRequestDTO productRequestDto) {
        Product product = ProductEntityDTOMapper.convertCreateProductRequestDTOToProduct(productRequestDto);
        Category saveCategory = categoryRepository.findById(productRequestDto.getCategoryId()).orElseThrow(
                ()-> new CategoryNotFoundException("Category not found for id" + productRequestDto.getCategoryId())
        );
        product.setCategory(saveCategory);
        product = productRepository.save(product);
        return ProductEntityDTOMapper.convertProductEntityToProductResponseDTO(product);
    }
    @Override
    public boolean deleteProduct(UUID productId){
        productRepository.deleteById(productId);
        return true;
    }
    @Override
    public ProductResponseDto findByproductName(String productName){
        return ProductEntityDTOMapper.convertProductEntityToProductResponseDTO(productRepository.findProductByTitle(productName));

    }
}
