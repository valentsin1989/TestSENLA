package com.gmail.valentsin1989.test.controller;

import com.gmail.valentsin1989.test.service.ProductService;
import com.gmail.valentsin1989.test.service.model.AddProductDTO;
import com.gmail.valentsin1989.test.service.model.AddedProductDTO;
import com.gmail.valentsin1989.test.service.model.ProductDTO;
import com.gmail.valentsin1989.test.service.model.ProductStatusEnum;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping(value = "/product/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> addProduct(@Validated @RequestBody AddProductDTO addProductDTO) {
        AddedProductDTO addedProduct = productService.addProduct(addProductDTO);
        if (addedProduct != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(addedProduct.getId());
        }
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(Map.of("message", "Product is not created."));
    }

    @DeleteMapping(value = "/product/delete/{productName}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> deleteProduct(@PathVariable String productName) {
        ProductDTO product = productService.getProduct(productName);
        if (product.getProductStatus() != ProductStatusEnum.IN_STOCK || product.getProductStatus() !=
                ProductStatusEnum.RUNNING_LOW) {
            boolean isDeleted = productService.deleteProduct(productName);
            return ResponseEntity.status(HttpStatus.OK).body(isDeleted);
        }
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(Map.of("message", "Product is not deleted."));
    }
}
