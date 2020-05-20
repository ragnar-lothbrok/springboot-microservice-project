package com.assignment.categoryservice.service;

import com.assignment.categoryservice.dto.CategoryDto;

import java.util.List;

public interface CategoryService {

    CategoryDto save(CategoryDto categoryDto);

    List<CategoryDto> categories();

}
