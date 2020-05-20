package com.assignment.categoryservice.controller;

import com.assignment.categoryservice.dto.CategoryDto;
import com.assignment.categoryservice.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/category")
public class CategoryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public CategoryDto create(CategoryDto categoryDto) {
        LOGGER.info("Request received = {} ", categoryDto);
        return categoryService.save(categoryDto);
    }

    @GetMapping
    public List<CategoryDto> get() {
        LOGGER.info("Retrieval request received.");
        return categoryService.categories();
    }

}
