package com.assignment.productservice.controller;

import com.assignment.productservice.dto.ProductDto;
import com.assignment.productservice.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/product/v1")
public class ProductController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @PostMapping
    public ProductDto create(@RequestBody ProductDto productDto) {
        LOGGER.info("Request received = {} ", productDto);
        return productService.save(productDto);
    }

    @PutMapping(value = "/{productId}")
    public ProductDto update(@PathVariable("productId") Long productId, @RequestBody ProductDto productDto) {
        LOGGER.info("Request received for update Product Id = {}  Product Dto= {} ", productId, productDto);
        return productService.update(productId, productDto);
    }

    @DeleteMapping(value = "/{productId}")
    public ProductDto delete(@PathVariable("productId") Long productId) {
        LOGGER.info("Request received for delete Product Id = {} ", productId);
        return productService.delete(productId);
    }

    @GetMapping
    public List<ProductDto> products() {
        LOGGER.info("Retrieval request received.");
        return productService.products();
    }

}
