package com.gmail.valentsin1989.test.service;

import com.gmail.valentsin1989.test.service.model.AddProductDTO;
import com.gmail.valentsin1989.test.service.model.AddedProductDTO;
import com.gmail.valentsin1989.test.service.model.ProductDTO;

public interface ProductService {
    AddedProductDTO addProduct(AddProductDTO addProductDTO);

    ProductDTO getProduct(String productName);

    boolean deleteProduct(String productName);
}
