package dev.sushmita.ProductService.exception;

//public class ProductNotFoundException extends RuntimeException{
//}

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String message) {
        super(message);
    }
}