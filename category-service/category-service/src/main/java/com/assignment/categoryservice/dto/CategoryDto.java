package com.assignment.categoryservice.dto;

import com.assignment.categoryservice.entities.Category;

public class CategoryDto {

    private Long id;

    private String category;

    private Long createdAt;

    private Long modifiedAt;

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

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public Long getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(Long modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public static CategoryDto build(Category category) {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(category.getId());
        categoryDto.setCategory(category.getCategory());
        categoryDto.setCreatedAt(category.getCreatedAt());
        categoryDto.setModifiedAt(category.getModifiedAt());
        categoryDto.setCreatedAt(category.getCreatedAt());
        return categoryDto;
    }

    @Override
    public String toString() {
        return "CategoryDto{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", createdAt=" + createdAt +
                ", modifiedAt=" + modifiedAt +
                '}';
    }
}
