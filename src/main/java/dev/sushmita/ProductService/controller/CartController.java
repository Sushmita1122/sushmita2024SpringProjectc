package dev.sushmita.ProductService.controller;

import dev.sushmita.ProductService.client.FakeStoreClient;
import dev.sushmita.ProductService.dto.FakeStoreCartResponseDTO;
import dev.sushmita.ProductService.dto.FakeStoreProductResponseDTO;
import dev.sushmita.ProductService.exception.CartNotFoundException;
import dev.sushmita.ProductService.exception.RandomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class CartController {
    @Autowired
    public FakeStoreClient fakeStoreClient;
    @GetMapping("/cart/{userId}")
        public ResponseEntity getCartForUser(@PathVariable("userId") int userId){
        List<FakeStoreCartResponseDTO> reponseBycartUser = fakeStoreClient.getCartByUserId(userId);
        if(reponseBycartUser == null){
            throw new CartNotFoundException("Cart not found for userID " + userId);
        }
        return ResponseEntity.ok(reponseBycartUser);

        }

    @GetMapping("/cartException")
    public ResponseEntity getCartException(){
        throw new RandomException("Exception From Cart");

    }
}
