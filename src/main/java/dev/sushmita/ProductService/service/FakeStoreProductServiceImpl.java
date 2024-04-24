package dev.sushmita.ProductService.service;

import dev.sushmita.ProductService.client.FakeStoreClient;
import dev.sushmita.ProductService.dto.FakeStoreProductResponseDTO;
import dev.sushmita.ProductService.entity.Product;
import dev.sushmita.ProductService.exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("fakeStoreImpl")
public class FakeStoreProductServiceImpl{

    @Autowired

    private FakeStoreClient fakeStoreClient;


    public List<FakeStoreProductResponseDTO> getAllproducts() {
        List<FakeStoreProductResponseDTO> fakeStoreProductResponseDTO=fakeStoreClient.getAllProducts();
        return fakeStoreProductResponseDTO;
    }


    public FakeStoreProductResponseDTO getProduct(int productId) throws ProductNotFoundException{
        FakeStoreProductResponseDTO result = fakeStoreClient.getProductById(productId);
        if(result == null){
            throw new ProductNotFoundException("Product not fount with id :" +productId );
        }
        return result;
    }


    public Product updateProduct(Product product, int productId) {
        return null;
    }


    public boolean deleteProduct(int productId) {
        return false;
    }


    public Product createProduct(Product product) {
        return null;
    }

}
