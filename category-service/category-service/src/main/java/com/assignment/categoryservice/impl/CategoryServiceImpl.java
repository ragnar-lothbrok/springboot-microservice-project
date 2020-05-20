package com.assignment.categoryservice.impl;

import com.assignment.categoryservice.dto.CategoryDto;
import com.assignment.categoryservice.entities.Category;
import com.assignment.categoryservice.repository.CategoryRepository;
import com.assignment.categoryservice.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryServiceImpl.class);

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public CategoryDto save(CategoryDto categoryDto) {
        LOGGER.info("Saving data for category = {} ", categoryDto);
        categoryDto.setId(null);
        categoryDto.setCreatedAt(null);
        categoryDto.setModifiedAt(null);
        return CategoryDto.build(categoryRepository.save(Category.build(categoryDto)));
    }

    @Override
    public List<CategoryDto> categories() {
        LOGGER.info("Fetching all categories.");
        return categoryRepository.findAll().stream().map(category -> CategoryDto.build(category)).collect(Collectors.toList());
    }
}
