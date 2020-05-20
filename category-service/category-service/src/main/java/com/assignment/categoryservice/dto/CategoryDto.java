package com.assignment.categoryservice.dto;

import com.assignment.categoryservice.entities.Category;

public class CategoryDto {

    private Long id;

    private String category;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public static CategoryDto build(Category category) {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(category.getId());
        categoryDto.setCategory(category.getCategory());
        return categoryDto;
    }

    @Override
    public String toString() {
        return "CategoryDto{" +
                "id=" + id +
                ", category='" + category + '\'' +
                '}';
    }
}
