package dev.sushmita.ProductService.exception;

import dev.sushmita.ProductService.controller.ProductController;
import dev.sushmita.ProductService.dto.ExceptionResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(basePackageClasses = ProductController.class)
public class ProductExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity handleNoProductException(ProductNotFoundException pe){
        ExceptionResponseDTO response = new ExceptionResponseDTO(
                pe.getMessage(),
                404
        );
        return  new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

    }
    @ExceptionHandler(RandomException.class)
    public ResponseEntity handleProductException(RandomException pe){
        ExceptionResponseDTO response = new ExceptionResponseDTO(
                pe.getMessage(),
                404
        );
        return  new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

    }

}
