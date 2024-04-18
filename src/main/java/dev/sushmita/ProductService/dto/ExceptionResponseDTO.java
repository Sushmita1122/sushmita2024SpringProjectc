package dev.sushmita.ProductService.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExceptionResponseDTO {
    String message;
    int code;

    public ExceptionResponseDTO(String message, int code) {
        System.out.println("just for testing purpose");
        this.message = message;
        this.code = code;
    }
}
