package dev.sushmita.ProductService.exception;

import dev.sushmita.ProductService.controller.CartController;
import dev.sushmita.ProductService.dto.ExceptionResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(basePackageClasses = CartController.class)
public class CartExceptionHandler {
    @ExceptionHandler(CartNotFoundException.class)
    public ResponseEntity cartNotFoundByUserId(CartNotFoundException ce){
        ExceptionResponseDTO response = new ExceptionResponseDTO(
                ce.getMessage(),
                404
        );
        return  new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(RandomException.class)
    public ResponseEntity handleCartException(RandomException pe) {
        ExceptionResponseDTO response = new ExceptionResponseDTO(
                pe.getMessage(),
                404
        );
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);



    }
}
