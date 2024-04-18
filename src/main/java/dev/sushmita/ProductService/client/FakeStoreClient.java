package dev.sushmita.ProductService.client;

import dev.sushmita.ProductService.dto.FakeStoreCartResponseDTO;
import dev.sushmita.ProductService.dto.FakeStoreProductResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class FakeStoreClient {
   @Autowired
    private RestTemplateBuilder restTemplateBuilder;
    @Value("${fakestore.api.base.url}")
    private String fakeStoreAPIBaseUrl;
    @Value("${fakestore.api.product.path}")
    private String fakeStoreAPIProductPath;
    @Value("${fakestore.api.cart.for.user.path}")
 private String fakeStoreAPICartForUser;


    public List<FakeStoreProductResponseDTO> getAllProducts(){
     String fakeStoreUrl = fakeStoreAPIBaseUrl.concat(fakeStoreAPIProductPath);
     System.out.println(fakeStoreUrl);
     RestTemplate restTemplate = restTemplateBuilder.build();
     ResponseEntity<FakeStoreProductResponseDTO[]> productResponseList=
             restTemplate.getForEntity(fakeStoreUrl,FakeStoreProductResponseDTO[].class);

     return List.of(productResponseList.getBody());
 }

 public FakeStoreProductResponseDTO getProductById(int id){
  String fakeStoreUrl = fakeStoreAPIBaseUrl.concat(fakeStoreAPIProductPath).concat("/" + id);
  System.out.println(fakeStoreUrl);
  RestTemplate restTemplate = restTemplateBuilder.build();
  ResponseEntity<FakeStoreProductResponseDTO> specificProduct= restTemplate.getForEntity(fakeStoreUrl,FakeStoreProductResponseDTO.class);
  return specificProduct.getBody();
 }

 public List<FakeStoreCartResponseDTO> getCartByUserId(int userId){
if(userId< 1){
 return null;
}
  String fakeStoreGetCartForUser = fakeStoreAPIBaseUrl.concat(fakeStoreAPICartForUser).concat(String.valueOf(userId));
     System.out.println(fakeStoreGetCartForUser);
RestTemplate restTemplate = restTemplateBuilder.build();
  ResponseEntity<FakeStoreCartResponseDTO[]> cartByUser=
          restTemplate.getForEntity(fakeStoreGetCartForUser,FakeStoreCartResponseDTO[].class);
  return List.of(cartByUser.getBody());
 }

}
