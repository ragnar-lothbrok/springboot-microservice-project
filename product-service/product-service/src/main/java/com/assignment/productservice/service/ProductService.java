package com.assignment.productservice.service;

import com.assignment.productservice.dto.ProductDto;

import java.util.List;

public interface ProductService {

    ProductDto save(ProductDto productDto);

    ProductDto update(Long productId, ProductDto productDto);

    ProductDto delete(Long productId);

    List<ProductDto> products();

}
