package com.assignment.productservice.impl;

import com.assignment.productservice.dto.ProductDto;
import com.assignment.productservice.entities.Product;
import com.assignment.productservice.repository.ProductRepository;
import com.assignment.productservice.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductDto save(ProductDto productDto) {
        productDto.setId(null);
        Product product = new Product();
        product.setName(productDto.getName());
        product.setCreatedAt(Instant.now().toEpochMilli());
        product.setModifiedAt(Instant.now().toEpochMilli());
        product.setPrice(productDto.getPrice());
        product.setQuantity(productDto.getQuantity());
        LOGGER.info("Product to be saved = {} ", productDto);
        return ProductDto.build(productRepository.save(product));
    }

    @Override
    public ProductDto update(Long productId, ProductDto productDto) {
        Optional<Product> productOptional = productRepository.findById(productId);
        Product product = null;
        if (productOptional.isPresent()) {
            product = productOptional.get();
        } else {
            LOGGER.info("Product not found for Id = {} ", productId);
            return save(productDto);
        }
        product.setName(productDto.getName());
        product.setModifiedAt(Instant.now().toEpochMilli());
        product.setPrice(productDto.getPrice());
        product.setQuantity(productDto.getQuantity());
        return ProductDto.build(productRepository.save(product));
    }

    @Override
    public ProductDto delete(Long productId) {
        Optional<Product> productOptional = productRepository.findById(productId);
        Product product = null;
        if (productOptional.isPresent()) {
            product = productOptional.get();
            productRepository.deleteById(productId);
        } else {
            LOGGER.info("Product not found for Id = {} ", productId);
        }
        return ProductDto.build(product);
    }

    @Override
    public List<ProductDto> products() {
        LOGGER.info("Fetching all categories.");
        return productRepository.findAll().stream().map(product -> ProductDto.build(product)).collect(Collectors.toList());
    }
}
